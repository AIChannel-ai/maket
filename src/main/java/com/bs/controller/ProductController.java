package com.bs.controller;

import com.bs.beans.CategoryBean;
import com.bs.beans.InParams;
import com.bs.beans.ProductBean;
import com.bs.service.ICategoryService;
import com.bs.service.ICommentService;
import com.bs.service.IOrderProductService;
import com.bs.service.IProductService;
import com.bs.tools.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

	@Resource
	IProductService _productService;
	@Resource
	ICategoryService _categoryService;
	@Resource
	IOrderProductService _orderProductService;
	@Resource
	ICommentService _commentService;

	@RequestMapping(value = "product/index")
	public String index(HttpServletRequest request, HttpSession session, @Param("cid") Integer cid,
			@Param("title") String title,Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		List<CategoryBean> category = _categoryService.getAll(null);
		map.put("category", category);
		map.put("cid", cid);
		map.put("title", title);
		return "client/product/index";
	}

	@RequestMapping(value = "product/getdata")
	public String getData(HttpServletRequest request, HttpSession session, @Param("cid") Integer cid,
			InParams parameter, Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		parameter.setCategoryid(cid);
		parameter.setPageSize(8);
		List<ProductBean> list = _productService.getAll(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());

		parameter.setPageSize(4);
		List<ProductBean> listnews = _productService.getAll2(parameter);
		Map<Integer, ProductBean> mapnews = new HashMap<>();
		for (ProductBean productBean : listnews) {
			mapnews.put(productBean.getId(), productBean);
		}
		map.put("mapnews", mapnews);

		parameter.setPageSize(8);
		List<ProductBean> listhots = _productService.getAll3(parameter);
		Map<Integer, ProductBean> maphots = new HashMap<>();
		for (ProductBean productBean : listhots) {
			maphots.put(productBean.getId(), productBean);
		}
		map.put("maphots", maphots);

		return "client/product/getdata";
	}

	@RequestMapping(value = "product/getone")
	public String getone(HttpServletRequest request, HttpSession session, @Param("id") Integer id, InParams parameter,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));

		List<CategoryBean> category = _categoryService.getAll(null);
		map.put("category", category);

		ProductBean bean = _productService.getById(id);
		map.put("bean", bean);

		parameter.setProductid(id);
		Integer allSale = _orderProductService.getScalar(parameter);
		if (allSale == null) {
			allSale = 0;
		}
		map.put("allSale", allSale);

		Integer allComment = _commentService.getScalar(parameter);
		if (allComment == null) {
			allComment = 0;
		}
		map.put("allComment", allComment);

		return "client/product/getone";
	}

	@RequestMapping(value = "product/indexby/{type}")
	public String indexby(@PathVariable String type, HttpServletRequest request, HttpSession session,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		List<CategoryBean> category = _categoryService.getAll(null);
		map.put("category", category);
		map.put("type", type);
		return "client/product/indexby";
	}

	@RequestMapping(value = "product/getdataby/{type}")
	public String getDataBy(@PathVariable String type, HttpServletRequest request, HttpSession session,
			InParams parameter, Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		parameter.setPageSize(8);
		List<ProductBean> list = null;
		if ("new".equals(type)) {
			list = _productService.getAll2(parameter);
		} else if ("hot".equals(type)) {
			list = _productService.getAll3(parameter);
		} else {
			list = _productService.getAll(parameter);
		}
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		map.put("type", type);
		
		if ("new".equals(type)) {
			return "client/product/getdataby";
		} else if ("hot".equals(type)) {
			return "client/product/getdataby";
		} else {
			return "client/product/getdata";
		}
	}
}
