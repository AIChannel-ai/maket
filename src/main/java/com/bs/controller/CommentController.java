package com.bs.controller;

import com.bs.beans.CommentBean;
import com.bs.beans.InParams;
import com.bs.service.ICommentService;
import com.bs.tools.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController extends ClientBaseController {

	@Resource
	private ICommentService _commentService;

	/**
	 * un use
	 * @param session
	 * @param parameter
	 * @param map
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "comment/index")
	public String index(HttpServletRequest request,HttpSession session, InParams parameter, Map<String, Object> map) {
		map.put("dictionary", Constant.getDictionary(request));
		if (getUser(session) == null) {
			return "redirect:/tologin?error=timeout";
		} else {
			parameter.setUserid(getUserId(session));
			List<CommentBean> list = _commentService.getAll(parameter);
			return "client/comment/index";
		}
	}

	@RequestMapping(value = "comment/getdata")
	public String getData(HttpServletRequest request,HttpSession session, InParams parameter, Map<String, Object> map)
			throws Exception {
		map.put("dictionary", Constant.getDictionary(request));
		List<CommentBean> list = _commentService.getAll(parameter);
		map.put("list", list);
		map.put("pageIndex", parameter.getPageIndex());
		map.put("pageSize", parameter.getPageSize());
		map.put("itemTotal", parameter.getItemTotal());
		map.put("number", parameter.getPageStart());
		return "client/comment/getdata";
	}
	
	@ResponseBody
	@RequestMapping("comment/addcomment")
	public MsgHelper addcomment(HttpSession session, InParams parameter, CommentBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {
			bean.setCreatedate(CommonUtils.getNowDateTime());
			bean.setUserid(getUserId(session));

			_commentService.insert(bean);
			msgHelper.setMessage("评论成功！");
		}

		return msgHelper;
	}

	@ResponseBody
	@RequestMapping("cart/deletecomment")
	public MsgHelper deletecart(HttpSession session, InParams parameter, CommentBean bean) {

		MsgHelper msgHelper = new MsgHelper();
		if (getUser(session) == null) {
			msgHelper.setCode(IntegerEnumType.NO_LOGIN.getValue());
			msgHelper.setMessage(StringEnumType.NO_LOGIN_MSG.getValue());
		} else {
			_commentService.delete(bean.getId());
		}
		return msgHelper;
	}

}
