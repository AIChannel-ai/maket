package com.bs.controller.admin;

import com.bs.beans.CategoryBean;
import com.bs.beans.InParams;
import com.bs.service.ICategoryService;
import com.bs.tools.Constant;
import com.bs.tools.MsgHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SysCategoryController{
	@Resource
	ICategoryService _categoryService;

	@RequestMapping(value = "admin/category/index")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "admin/category/index";
	}

	@RequestMapping(value = "admin/category/getdata")
	public String getData(HttpServletRequest request,HttpSession session, InParams parameter, Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		List<CategoryBean> list = _categoryService.getAll(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "/admin/category/getdata";
	}

	@RequestMapping(value = "admin/category/toadd")
	public String toAdd(HttpServletRequest request,HttpSession session, @Param("id") Integer id, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		CategoryBean bean = new CategoryBean();
		if (id != null){
			bean = _categoryService.getById(id);
		}
		map.put("bean", bean);
		return "admin/category/toadd";
	}

	@ModelAttribute
	public void getBean(HttpSession session, @RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			CategoryBean bean = _categoryService.getById(id);
			map.put("bean", bean);
		}
	}

	@ResponseBody
	@RequestMapping(value = "admin/category/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session, @ModelAttribute("bean") CategoryBean bean) throws Exception {
		MsgHelper msgHelper = new MsgHelper();
		if (bean.getId() == null)
			_categoryService.insert(bean);
		else {
			_categoryService.update(bean);
		}
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/category/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_categoryService.delete(id);
		return msgHelper;
	}
}
