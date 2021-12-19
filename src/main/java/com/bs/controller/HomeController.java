package com.bs.controller;

import com.bs.beans.CategoryBean;
import com.bs.beans.InParams;
import com.bs.beans.ProductBean;
import com.bs.service.ICategoryService;
import com.bs.service.IProductService;
import com.bs.tools.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
	
	@Resource
	IProductService _productService;
	@Resource
	ICategoryService _categoryService;
	
	@RequestMapping(value="/")
	public String index(HttpSession session,Map<String, Object> map) {
		return "index";
	}
	
	@RequestMapping(value="/index.shtml")
	public String indexshtml(HttpServletRequest request,HttpSession session,InParams parameter, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		
		List<CategoryBean> category = _categoryService.getAll(null);
		map.put("category", category);
		
		parameter.setPageSize(4);
		List<ProductBean> listnews = _productService.getAll2(parameter);
		map.put("listnews", listnews);
		
		parameter.setPageSize(8);
		List<ProductBean> listhots = _productService.getAll3(parameter);
		map.put("listhots", listhots);
		
		return "client/index";
	}
}
