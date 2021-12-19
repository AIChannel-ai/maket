package com.bs.controller.admin;

import com.bs.beans.ComponentBean;
import com.bs.beans.InParams;
import com.bs.beans.UserBean;
import com.bs.service.IComponentService;
import com.bs.tools.CommonUtils;
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
public class SysComponentController{
	@Resource
	IComponentService _componentService;

	@RequestMapping(value = "admin/component/index")
	public String index(HttpServletRequest request,HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "admin/component/index";
	}

	@RequestMapping(value = "admin/component/getdata")
	public String getData(HttpServletRequest request,HttpSession session, InParams parameter, Map<String, Object> map) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		List<ComponentBean> list = _componentService.getAll(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "/admin/component/getdata";
	}

	@RequestMapping(value = "admin/component/toadd")
	public String toAdd(HttpServletRequest request,HttpSession session, @Param("id") Integer id, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		ComponentBean bean = new ComponentBean();
		if (id != null){
			bean = _componentService.getById(id);
		}
		map.put("bean", bean);
		return "admin/component/toadd";
	}

	@ModelAttribute
	public void getBean(HttpSession session, @RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			ComponentBean bean = _componentService.getById(id);
			map.put("bean", bean);
		}
	}

	@ResponseBody
	@RequestMapping(value = "admin/component/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session, @ModelAttribute("bean") ComponentBean bean) throws Exception {
		MsgHelper msgHelper = new MsgHelper();
		bean.setCreatedate(CommonUtils.getNowDateTime());
		UserBean user = (UserBean)session.getAttribute("user");
		bean.setUserid(user.getId());
		if (bean.getId() == null)
			_componentService.insert(bean);
		else {
			_componentService.update(bean);
		}
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/component/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_componentService.delete(id);
		return msgHelper;
	}
}
