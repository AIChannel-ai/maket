package com.bs.controller.admin;

import com.bs.beans.UserBean;
import com.bs.service.IUserService;
import com.bs.tools.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/admin/")
@Controller
public class SysLoginController {

	@Resource
	private IUserService _service;

	@RequestMapping("login")
	public String login(HttpServletRequest request,HttpSession session, String error, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		session.setAttribute("user", null);
		session.setAttribute("error", error);
		return "/admin/login";
	}

	@RequestMapping("loginExpire")
	public String loginExpire() {
		return "/admin/loginExpire";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("usertype") String usertype, HttpSession session) {
		UserBean user = _service.login(username, password, usertype);

		if (user == null) {
			return "redirect:/admin/login?error=on";
		} else {
			session.setAttribute("user", user);
			return "redirect:/admin/index";
		}
	}
}
