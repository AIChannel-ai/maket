package com.bs.controller;

import com.bs.beans.UserBean;

import javax.servlet.http.HttpSession;

public class ClientBaseController {

	public UserBean getUser(HttpSession session) {
		Object bean = session.getAttribute("c_user");
		if (bean != null) {
			return (UserBean) bean;
		}
		return null;
	}

	public Integer getUserId(HttpSession session) {
		if (getUser(session) != null) {
			return getUser(session).getId();
		}
		return null;
	}
}
