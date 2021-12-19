package com.bs.controller.admin;

import com.bs.beans.CommentBean;
import com.bs.beans.InParams;
import com.bs.beans.UserBean;
import com.bs.service.ICommentService;
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
public class SysCommentController {
	@Resource
	ICommentService _commentService;

	@RequestMapping(value = "/admin/comment/index")
	public String index(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		return "admin/comment/index";
	}

	@RequestMapping(value = "admin/comment/getdata")
	public String getData(HttpServletRequest request, HttpSession session, InParams parameter, Map<String, Object> map)
			throws Exception {
		map.put("dictionary", Constant.getDictionary(request));

		List<CommentBean> list = _commentService.getAll2(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "/admin/comment/getdata";
	}

	@RequestMapping(value = "admin/comment/toreplay")
	public String toAdd(HttpServletRequest request, HttpSession session, @Param("id") Integer id,
			Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		CommentBean bean = new CommentBean();
		if (id != null) {
			bean = _commentService.getById(id);
		}
		map.put("bean", bean);
		return "admin/comment/toreplay";
	}

	@ResponseBody
	@RequestMapping(value = "admin/comment/save", method = RequestMethod.POST)
	public MsgHelper save(HttpSession session, HttpServletRequest request, @ModelAttribute("bean") CommentBean bean) {
		MsgHelper msgHelper = new MsgHelper();
		bean.setReplydate(CommonUtils.getNowDateTime());
		UserBean user = (UserBean) session.getAttribute("user");
		bean.setReplyuserid(user.getId());
		msgHelper.setUrl(request.getContextPath() + "/admin/comment/index");
		_commentService.update(bean);
		return msgHelper;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/comment/delete", method = RequestMethod.POST)
	public MsgHelper delete(Integer id) {
		MsgHelper msgHelper = new MsgHelper();
		_commentService.delete(id);
		return msgHelper;
	}
}
