package com.bs.controller;

import com.bs.beans.InParams;
import com.bs.beans.MessageBean;
import com.bs.beans.UserBean;
import com.bs.service.IMessageService;
import com.bs.tools.CommonUtils;
import com.bs.tools.Constant;
import com.bs.tools.MsgHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController extends ClientBaseController {
	@Resource
	IMessageService _messageService;

	@RequestMapping(value = "message/tomessage")
	public String index(HttpServletRequest request, HttpSession session,InParams parameter, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		
		if (getUser(session) != null) {
			parameter.setUserid(getUserId(session));
			List<MessageBean> list = _messageService.getAll2(parameter);
			map.put("list", list);
		}
		
		return "client/message/tomessage";
	}

	@ResponseBody
	@RequestMapping(value = "message/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session, HttpServletRequest request, @ModelAttribute("bean") MessageBean bean) {
		MsgHelper msgHelper = new MsgHelper();
		bean.setCreatedate(CommonUtils.getNowDateTime());
		UserBean user = getUser(session);
		if (user != null) {
			bean.setUserid(user.getId());
			msgHelper.setUrl(request.getContextPath() + "/message/tomessage");
		}

		_messageService.insert(bean);

		return msgHelper;
	}

	@RequestMapping(value = "message/getdata")
	public String getData(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map)
			throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		if (getUser(session) != null) {
			parameter.setUserid(getUserId(session));
			List<MessageBean> list = _messageService.getAll2(parameter);
			map.put("list", list);
			map.put("pageIndex", parameter.getPageIndex());
			map.put("pageSize", parameter.getPageSize());
			map.put("itemTotal", parameter.getItemTotal());
			map.put("number", parameter.getPageStart());
		}
		return "client/message/getdata";
	}

	@ResponseBody
	@RequestMapping(value = "message/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_messageService.delete(id);
		return msgHelper;
	}
}
