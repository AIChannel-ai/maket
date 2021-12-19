package com.bs.controller.admin;

import com.bs.beans.InParams;
import com.bs.beans.OrderBean;
import com.bs.service.ICategoryService;
import com.bs.service.IOrderService;
import com.bs.service.IProductService;
import com.bs.tools.Constant;
import com.bs.tools.MsgHelper;
import com.bs.tools.StringEnumType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SysOrderController {
	@Resource
	IProductService _productService;
	@Resource
	ICategoryService _categoryService;
	@Resource
	IOrderService _orderService;
	
	@RequestMapping(value = "/admin/order/indexmanage")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		map.put("status",Constant.getOrderStatus());
		return "admin/order/index";
	}

	@RequestMapping(value = "admin/order/getdata")
	public String getData(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		
		List<OrderBean> list = _orderService.getAll(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		
		map.put("NO_SEND", StringEnumType.NO_SEND.getValue());
		return "/admin/order/getdata";
	}

	@ResponseBody
	@RequestMapping(value = "admin/order/send", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session,HttpServletRequest request,@RequestParam Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		OrderBean orderBean = new OrderBean();
		orderBean.setId(id);
		orderBean.setStatus(StringEnumType.SENDING.getValue());
		_orderService.update2(orderBean);
		return msgHelper;
	}
}
