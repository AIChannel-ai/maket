package com.bs.controller.admin;

import com.bs.beans.InParams;
import com.bs.beans.MessageBean;
import com.bs.beans.UserBean;
import com.bs.service.IMessageService;
import com.bs.tools.CommonUtils;
import com.bs.tools.Constant;
import com.bs.tools.MsgHelper;
import org.apache.ibatis.annotations.Param;
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
public class SysMessageController {
	@Resource
	IMessageService _messageService;

	@RequestMapping(value = "/admin/message/index")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "admin/message/index";
	}

	@RequestMapping(value = "admin/message/getdata")
	public String getData(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map)
			throws Exception {
		map.put("dictionary", Constant.getDictionary(request));

		List<MessageBean> list = _messageService.getAll2(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "/admin/message/getdata";
	}

	@RequestMapping(value = "admin/message/toreplay")
	public String toAdd(HttpServletRequest request, HttpSession session, @Param("id") Integer id,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		MessageBean bean = new MessageBean();
		if (id != null) {
			bean = _messageService.getById(id);
		}
		map.put("bean", bean);
		return "admin/message/toreplay";
	}

	@ResponseBody
	@RequestMapping(value = "admin/message/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session, HttpServletRequest request, @ModelAttribute("bean") MessageBean bean) {
		MsgHelper msgHelper = new MsgHelper();
		bean.setReplydate(CommonUtils.getNowDateTime());
		UserBean user = (UserBean) session.getAttribute("user");
		bean.setReplyuserid(user.getId());
		msgHelper.setUrl(request.getContextPath() + "/admin/message/index");
		_messageService.update(bean);
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/message/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_messageService.delete(id);
		return msgHelper;
	}
}
