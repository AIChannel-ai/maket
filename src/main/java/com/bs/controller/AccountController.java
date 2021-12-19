package com.bs.controller;

import com.bs.beans.InParams;
import com.bs.beans.UserBean;
import com.bs.service.IUserService;
import com.bs.tools.CommonUtils;
import com.bs.tools.Constant;
import com.bs.tools.MsgHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AccountController {

	@Resource
	private IUserService _service;

	@RequestMapping("/tologin")
	public String tologin(HttpServletRequest request, HttpSession session, String error, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		session.setAttribute("c_user", null);
		session.setAttribute("error", error);
		return "client/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("usertype") String usertype, HttpSession session) {
		UserBean user = _service.login(username, password, usertype);

		if (user == null) {
			return "redirect:/tologin?error=on";
		} else {
			session.setAttribute("c_user", user);
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "loginout" })
	public String loginout(HttpSession session) {
		session.setAttribute("c_user", null);
		return "redirect:/";
	}

	@RequestMapping("/toregister")
	public String toregister(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		session.setAttribute("c_user", null);
		return "client/account/register";
	}

	@ResponseBody
	@RequestMapping("/register")
	public MsgHelper register(HttpServletRequest request, HttpSession session, UserBean bean, InParams parameter) {
		MsgHelper msgHelper = new MsgHelper("恭喜您注册成功，系统已自动登录！");
		if(StringUtils.isEmpty(bean.getUsername())){
			msgHelper.setCode(-100);
			msgHelper.setMessage("用户名不能为空！");
			return msgHelper;
		}
		parameter.setUsername(bean.getUsername());
		UserBean userBean = _service.getOne1(parameter);
		if (userBean == null) {
			bean.setCreatedate(CommonUtils.getNowDateTime());
			_service.insert(bean);
			UserBean user = _service.getLastOne();
			session.setAttribute("c_user", user);
			msgHelper.setUrl(request.getServletContext().getContextPath());
		} else {
			msgHelper.setCode(-100);
			msgHelper.setMessage("该用户名已经存在，请重新注册！");
		}
		//JSONObject json = (JSONObject) JSON.toJSON(msgHelper);
		//request.setAttribute("json", json);
		return msgHelper;
	}

	@RequestMapping("/tochpwd")
	public String tochpwd(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "client/account/chpwd";
	}

	@ResponseBody
	@RequestMapping(value = "/savepwd")
	public MsgHelper savepwd(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword,
			HttpSession session) throws Exception {
		MsgHelper msgHelper = new MsgHelper();
		UserBean loginUser = (UserBean) session.getAttribute("c_user");

		UserBean user = _service.login(loginUser.getUsername(), oldPassword, loginUser.getUsertype());
		if (user == null) {
			msgHelper.setMessage("原密码不正确！");
			msgHelper.setCode(500);
		} else {
			msgHelper.setMessage("密码修改成功，请重新登录！");
			_service.modifyPwd(loginUser.getId(), newPassword);
		}
		return msgHelper;
	}

	@RequestMapping("/tomyinfo")
	public String tomyinfo(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		UserBean loginUser = (UserBean) session.getAttribute("c_user");
		map.put("bean", loginUser);
		return "client/account/myinfo";
	}

	@ResponseBody
	@RequestMapping("/savemyinfo")
	public MsgHelper savemyinfo(HttpSession session, UserBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		UserBean loginUser = (UserBean) session.getAttribute("c_user");
		bean.setId(loginUser.getId());
		_service.saveMyInfo(bean);

		return msgHelper;
	}
}
