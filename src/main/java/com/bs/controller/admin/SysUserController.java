package com.bs.controller.admin;

import com.bs.beans.InParams;
import com.bs.beans.UserBean;
import com.bs.service.IUserService;
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
public class SysUserController {
	@Resource
	IUserService _userService;

	@RequestMapping(value = "admin/user/index")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "admin/user/index";
	}

	@RequestMapping(value = "admin/user/getdata")
	public String getData(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map)
			throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		List<UserBean> list = _userService.getAll(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "/admin/user/getdata";
	}

	@RequestMapping(value = "admin/user/toadd")
	public String toAdd(HttpServletRequest request, HttpSession session, @Param("id") Integer id,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		UserBean bean = new UserBean();
		if (id != null) {
			bean = _userService.getById(id);
		}
		map.put("bean", bean);
		return "admin/user/toadd";
	}

	@ModelAttribute
	public void getBean(HttpSession session, @RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			UserBean bean = _userService.getById(id);
			map.put("bean", bean);
		}
	}

	@ResponseBody
	@RequestMapping(value = "admin/user/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session, @ModelAttribute("bean") UserBean bean) throws Exception {
		MsgHelper msgHelper = new MsgHelper();

		InParams parameter = new InParams();
		parameter.setUsername(bean.getUsername());
		UserBean user = _userService.getOne1(parameter);

		bean.setCreatedate(CommonUtils.getNowDateTime());
		if (bean.getId() == null)
			if (user != null) {
				msgHelper.setCode(300);
				msgHelper.setMessage("该账号已经存在，不能重复添加！");
			} else {
				_userService.insert(bean);
			}
		else {
			if (user != null && user.getId() != bean.getId()) {
				msgHelper.setCode(300);
				msgHelper.setMessage("该账号已经存在，不能重复添加！");
			} else {
				_userService.update(bean);
			}
		}
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_userService.delete(id);
		return msgHelper;
	}

	@RequestMapping(value = "admin/user/myinfo")
	public String toMyInfo(HttpServletRequest request, Map<String, Object> map, HttpSession session) throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		UserBean loginUser = (UserBean) session.getAttribute("user");
		map.put("bean", loginUser);
		return "admin/user/myinfo";
	}

	@ResponseBody
	@RequestMapping(value = "admin/user/savemyinfo")
	public MsgHelper saveMyInfo(Map<String, Object> map, HttpSession session, @ModelAttribute("bean") UserBean bean)
			throws Exception {
		MsgHelper msgHelper = new MsgHelper();
		UserBean loginUser = (UserBean) session.getAttribute("user");
		bean.setId(loginUser.getId());
		
		InParams parameter = new InParams();
		parameter.setUsername(bean.getUsername());
		UserBean user = _userService.getOne1(parameter);
		if (user != null && user.getId() != bean.getId()) {
			msgHelper.setCode(300);
			msgHelper.setMessage("该账号已经存在，不能重复添加！");
		} else {
			_userService.saveMyInfo(bean);
		}
		return msgHelper;
	}

	@RequestMapping(value = "admin/user/tochpwd")
	public String toChpwd(Map<String, Object> map, HttpSession session) throws Exception {
		UserBean loginUser = (UserBean) session.getAttribute("user");
		map.put("user", loginUser);
		return "admin/user/chpwd";
	}

	@ResponseBody
	@RequestMapping(value = "admin/user/chpwd")
	public MsgHelper chpwd(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword,
			HttpSession session) throws Exception {
		MsgHelper msgHelper = new MsgHelper();
		UserBean loginUser = (UserBean) session.getAttribute("user");

		UserBean user = _userService.login(loginUser.getUsername(), oldPassword, loginUser.getUsertype());
		if (user == null) {
			msgHelper.setMessage("原密码不正确！");
		} else {
			_userService.modifyPwd(loginUser.getId(), newPassword);
		}
		return msgHelper;
	}
}
