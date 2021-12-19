package com.bs.controller;

import com.bs.beans.CartBean;
import com.bs.beans.ComponentBean;
import com.bs.beans.InParams;
import com.bs.beans.ProductBean;
import com.bs.service.ICartService;
import com.bs.service.IComponentService;
import com.bs.service.IProductService;
import com.bs.tools.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CartController extends ClientBaseController {

	@Resource
	private ICartService _service;
	@Resource
	private IComponentService _componentService;
	@Autowired
	private IProductService _productService;

	@RequestMapping(value = "cart/index")
	public String index(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		if (getUser(session) == null) {
			return "redirect:/tologin?error=timeout";
		} else {
			parameter.setUserid(getUserId(session));
			List<CartBean> list = _service.getAll(parameter);

			map.put("list", list);
			Integer sumPrice = 0;
			for (CartBean c : list) {
				sumPrice += c.getSubprice();
			}
			map.put("sumprice", sumPrice);

			return "client/cart/index";
		}
	}

	@ResponseBody
	@RequestMapping("cart/addcart")
	public MsgHelper addcart(HttpSession session, InParams parameter, CartBean bean, Integer number) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {
			bean.setCreatedate(CommonUtils.getNowDateTime());
			bean.setUserid(getUserId(session));
			if (number == null) {
				number = 1;
			}

			ProductBean product = _productService.getById(parameter.getProductid());
			if (number > product.getNumber()) {
				msgHelper.setCode(400);
				msgHelper.setMessage("库存不足，加入购物车失败！");
			}else{
				parameter.setUserid(getUserId(session));
				CartBean one = _service.getOne1(parameter);

				if (one == null) {
					bean.setNumber(number);
					_service.insert(bean);
				} else {
					bean.setNumber(number + one.getNumber());
					bean.setId(one.getId());
					_service.update2(bean);
				}
				msgHelper.setMessage("加入购物车成功！");
			}
		}

		return msgHelper;
	}

	@ResponseBody
	@RequestMapping("cart/removecart")
	public MsgHelper removecart(HttpSession session, InParams parameter, CartBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {
			bean.setCreatedate(CommonUtils.getNowDateTime());
			bean.setUserid(getUserId(session));

			parameter.setUserid(getUserId(session));
			CartBean one = _service.getOne1(parameter);

			Integer number = one.getNumber() - 1;
			if (number < 0) {
				msgHelper.setMessage("您的商品已经移除完毕！");
			} else {
				bean.setNumber(number);
				bean.setId(one.getId());
				_service.update2(bean);
				msgHelper.setMessage("移除购物车成功！");
			}
		}

		return msgHelper;
	}

	@ResponseBody
	@RequestMapping("cart/deletecart")
	public MsgHelper deletecart(HttpSession session, InParams parameter, CartBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {
			_service.delete(bean.getId());
		}
		return msgHelper;
	}

	@RequestMapping(value = "cart/tocheckout")
	public String tocheckout(HttpServletRequest request, HttpSession session, InParams parameter,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		if (getUser(session) == null) {
			return "redirect:/tologin?error=timeout";
		} else {

			parameter.setUserid(getUserId(session));
			parameter.setType1(StringEnumType.ADDRESS.getValue());
			List<ComponentBean> address = _componentService.getAll(parameter);
			map.put("address", address);

			parameter = new InParams();
			parameter.setUserid(getUserId(session));
			List<CartBean> list = _service.getAll(parameter);

			map.put("list", list);
			Integer sumPrice = 0;
			for (CartBean c : list) {
				sumPrice += c.getSubprice();
			}
			map.put("sumprice", sumPrice);

			return "client/cart/tocheckout";
		}
	}

}
