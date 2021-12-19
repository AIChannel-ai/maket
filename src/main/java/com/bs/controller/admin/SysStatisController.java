package com.bs.controller.admin;

import com.alibaba.fastjson.JSON;
import com.bs.beans.InParams;
import com.bs.beans.OrderBean;
import com.bs.beans.OrderProductBean;
import com.bs.service.ICategoryService;
import com.bs.service.IOrderProductService;
import com.bs.service.IOrderService;
import com.bs.service.IProductService;
import com.bs.tools.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class SysStatisController {
	@Resource
	IProductService _productService;
	@Resource
	ICategoryService _categoryService;
	@Resource
	IOrderService _orderService;
	@Resource
	IOrderProductService _orderProductService;

	@RequestMapping(value = "/admin/statis/salestatis")
	public String salestatis(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		// 销量-按月
		return "/admin/statis/salestatis";
	}

	@RequestMapping(value = "admin/statis/salestatisgetdata")
	public String salestatisgetdata(HttpServletRequest request, HttpSession session, InParams parameter,
			Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));

		List<OrderBean> list = _orderService.getAll4(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());

		return "admin/statis/salestatisgetdata";
	}

	@RequestMapping(value = "/admin/statis/categorystatis")
	public String categorystatis(HttpServletRequest request, HttpSession session, InParams parameter,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		// 销量-按类型统计图
		List<OrderProductBean> list = _orderProductService.getAll5(parameter);
		List<String> xAxis = list.stream().map(OrderProductBean::getTitle).collect(Collectors.toList());
		// {value:335, name:'直接访问'}
		List<String> yAxis = list.stream().map((o) -> {
			return "{value:" + o.getNumber() + ",name:'" + o.getTitle() + "'}";
		}).collect(Collectors.toList());
		String jsonxAxis = JSON.toJSONString(xAxis);
		String jsonyAxis = yAxis.toString();
		map.put("jsonxAxis", jsonxAxis);
		map.put("jsonyAxis", jsonyAxis);
		return "/admin/statis/categorystatis";
	}

	@RequestMapping(value = "/admin/statis/datestatis")
	public String datestatis(HttpServletRequest request, HttpSession session, InParams parameter,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		// 销量-按月统计图
		List<OrderProductBean> list = _orderProductService.getAll4(parameter);
		List<String> xAxis = list.stream().map(OrderProductBean::getCreatedate).collect(Collectors.toList());
		List<Integer> yAxis = list.stream().map(OrderProductBean::getNumber).collect(Collectors.toList());
		String jsonxAxis = JSON.toJSONString(xAxis);
		String jsonyAxis = JSON.toJSONString(yAxis);
		map.put("jsonxAxis", jsonxAxis);
		map.put("jsonyAxis", jsonyAxis);
		return "/admin/statis/datestatis";
	}

	@RequestMapping(value = "/admin/statis/foundstatis")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		// 销售额-按月
		return "/admin/statis/foundstatis";
	}

	@RequestMapping(value = "admin/statis/foundstatisgetdata")
	public String foundstatisgetdata(HttpServletRequest request, HttpSession session, InParams parameter,
			Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));

		List<OrderBean> list = _orderService.getAll4(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());

		return "admin/statis/foundstatisgetdata";
	}

}
