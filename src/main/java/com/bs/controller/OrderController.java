package com.bs.controller;

import com.bs.beans.*;
import com.bs.service.ICartService;
import com.bs.service.IOrderProductService;
import com.bs.service.IOrderService;
import com.bs.service.IProductService;
import com.bs.tools.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderController extends ClientBaseController {

	@Resource
	IOrderService _orderService;
	@Resource
	private ICartService _cartService;
	@Resource
	private IOrderProductService _orderProductService;
	@Resource
	private IProductService _productService;

	@RequestMapping(value = "order/index")
	public String index(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));

		if (getUser(session) == null) {
			return "redirect:/tologin?error=timeout";
		} else {
			// get orders
			parameter.setUserid(getUserId(session));
			List<OrderBean> list = _orderService.getAll(parameter);
			parameter = new InParams();

			// get product by order
			for (OrderBean o : list) {
				parameter.setOrderid(o.getId());
				List<OrderProductBean> orderProduct = _orderProductService.getAll(parameter);
				o.setOrderProduct(orderProduct);
			}

			map.put("list", list);
		}

		return "client/order/index";
	}

	@ResponseBody
	@RequestMapping("order/addorder")
	public MsgHelper addorder(HttpSession session, InParams parameter, OrderBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
			return msgHelper;
		}

		Map<String, Integer> mapError = new HashMap<>();
		mapError.put("stock0all", 0);
		mapError.put("stock0part", 0);
		List<CartBean> listCart = new ArrayList<>();

		// 0.get cart product
		parameter = new InParams();
		parameter.setUserid(getUserId(session));
		List<CartBean> list = _cartService.getAll(parameter);

		Integer sumPrice = 0;
		// 1 check store
		for (CartBean c : list) {
			// 2.1 check product store
			ProductBean product = _productService.getById(c.getProductid());
			Integer stockNumber = product.getNumber();
			Integer saleNumber = c.getNumber();
			Integer orderNumber = saleNumber;
			// 全0
			if (stockNumber == 0) {
				int stock0all = mapError.get("stock0all");
				mapError.put("stock0all", ++stock0all);
			}
			// 部分0
			else if (saleNumber > stockNumber) {
				orderNumber = stockNumber;
				sumPrice += (product.getPrice() * orderNumber);
				c.setOrderProductBean(new OrderProductBean(product.getId(), orderNumber));
				listCart.add(c);

				int stock0part = mapError.get("stock0part");
				mapError.put("stock0part", ++stock0part);

			} else {
				sumPrice += (product.getPrice() * orderNumber);
				c.setOrderProductBean(new OrderProductBean(product.getId(), orderNumber));
				listCart.add(c);
			}
		}
		bean.setSumprice(sumPrice);

		if (mapError.get("stock0all") == list.size()) {
			msgHelper.setCode(IntegerEnumType.ZERO_STOCK.getValue());
			msgHelper.setMessage("抱歉，由于库存不足订单生成失败！");
			return msgHelper;
		}

		// 2.create order ******
		bean.setCreatedate(CommonUtils.getNowDateTime());
		bean.setUserid(getUserId(session));
		bean.setOrdername("系统自动生成");
		bean.setOrdercode(new SimpleDateFormat("MMddhhmmss").format(new Date()));
		bean.setStatus(StringEnumType.NO_SEND.getValue());
		_orderService.insert(bean);

		// 3.create order-product
		OrderBean lastOne = _orderService.getLastOne();
		for (CartBean c : listCart) {

			OrderProductBean opb = c.getOrderProductBean();
			opb.setOrderid(lastOne.getId());
			_orderProductService.insert(opb);

			// 2.2 update stock number
			ProductBean productBean = new ProductBean();
			productBean.setId(c.getProductid());
			ProductBean product = _productService.getById(c.getProductid());
			productBean.setNumber(product.getNumber() - opb.getNumber());
			_productService.update2(productBean);
		}
		// 4. clear cart
		parameter = new InParams();
		parameter.setUserid(getUserId(session));
		_cartService.delete2(parameter);
		int stock0part = mapError.get("stock0part");
		int stock0all = mapError.get("stock0all");
		if (stock0part > 0 || (stock0all > 0 && stock0all != list.size())) {
			msgHelper.setCode(IntegerEnumType.NO_STOCK.getValue());
			msgHelper.setMessage("订单生成成功！但由于部分商品库存不足，未能按购物数量生成订单！");
		} else {
			msgHelper.setMessage("恭喜您，订单生成成功！");
		}
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping("order/cancelorder")
	public MsgHelper cancelorder(HttpSession session, InParams parameter, OrderBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {
			Integer orderId = bean.getId();

			// 1.get order-product -> delete
			parameter = new InParams();
			parameter.setOrderid(orderId);
			List<OrderProductBean> list = _orderProductService.getAll(parameter);

			for (OrderProductBean c : list) {

				// 1.1 update stock number
				ProductBean product = _productService.getById(c.getProductid());
				Integer stockNumber = product.getNumber();
				Integer orderNumber = c.getNumber();

				ProductBean productBean = new ProductBean();
				productBean.setId(c.getProductid());
				productBean.setNumber(stockNumber + orderNumber);
				_productService.update2(productBean);

				// 1.2 delete order-product
				_orderProductService.delete(c.getId());
			}

			// 2.delete order
			_orderService.delete(orderId);

			msgHelper.setMessage("订单取消成功！");
		}

		return msgHelper;
	}

	@ResponseBody
	@RequestMapping("order/getproduct")
	public MsgHelper getproduct(HttpSession session, InParams parameter, OrderBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {

			bean.setStatus(StringEnumType.SEND_DONE.getValue());
			_orderService.update2(bean);

			msgHelper.setMessage("收货成功！");
		}

		return msgHelper;
	}
}
