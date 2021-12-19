package com.bs.controller.admin;

import com.bs.beans.CategoryBean;
import com.bs.beans.InParams;
import com.bs.beans.ProductBean;
import com.bs.beans.UserBean;
import com.bs.service.ICategoryService;
import com.bs.service.IProductService;
import com.bs.tools.CommonUtils;
import com.bs.tools.Constant;
import com.bs.tools.MsgHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class SysProductController {
	@Resource
	IProductService _productService;
	@Resource
	ICategoryService _categoryService;
	
	@RequestMapping(value = "/admin/product/index")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "admin/product/index";
	}

	@RequestMapping(value = "admin/product/getdata")
	public String getData(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		
		List<ProductBean> list = _productService.getAll4(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "/admin/product/getdata";
	}

	@RequestMapping(value = "admin/product/toadd")
	public String toAdd(HttpServletRequest request, HttpSession session, @Param("id") Integer id, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		
		List<CategoryBean> category = _categoryService.getAll(null);
		map.put("category", category);
		
		ProductBean bean = new ProductBean();
		bean.setProductcode(String.valueOf(System.currentTimeMillis()));
		if (id != null){
			bean = _productService.getById(id);
		}
		
		map.put("bean", bean);
		return "admin/product/toadd";
	}

	@ModelAttribute
	public void getBean(HttpSession session, @RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			ProductBean bean = _productService.getById(id);
			map.put("bean", bean);
		}
	}

	@ResponseBody
	@RequestMapping(value = "admin/product/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("bean") ProductBean bean) throws Exception {
		MsgHelper msgHelper = new MsgHelper();
		if (file != null) {
			String extName = CommonUtils.getExtension(file.getOriginalFilename());
			String fileName = CommonUtils.getUUID() + extName;
			String savePath = request.getServletContext().getRealPath("upload_files") + "/" + fileName;
			
			bean.setImagepath(fileName);
			file.transferTo(new File(savePath));
		}
		
		bean.setCreatedate(CommonUtils.getNowDateTime());
		UserBean user = (UserBean)session.getAttribute("user");
		bean.setUserid(user.getId());
		
		if (bean.getId() == null)
			_productService.insert(bean);
		else {
			_productService.update(bean);
		}
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/product/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_productService.delete(id);
		return msgHelper;
	}
}
