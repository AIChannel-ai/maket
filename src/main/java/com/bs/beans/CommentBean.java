package com.bs.beans;

public class CommentBean extends ABaseBean {
	
	private Integer id;
	private String content;
	private String createdate;
	private Integer userid;
	private Integer productid;
	private String replycontent;
	private String replydate;
	private Integer replyuserid;
	
	private String commentname ; //评论人
	private String replayname; //回复人
	private String title; //product name
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}
	public Integer getReplyuserid() {
		return replyuserid;
	}
	public void setReplyuserid(Integer replyuserid) {
		this.replyuserid = replyuserid;
	}
	public String getCommentname() {
		return commentname;
	}
	public void setCommentname(String commentname) {
		this.commentname = commentname;
	}
	public String getReplayname() {
		return replayname;
	}
	public void setReplayname(String replayname) {
		this.replayname = replayname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
