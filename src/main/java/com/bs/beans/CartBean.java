package com.bs.beans;

public class CartBean extends ABaseBean {
	
	private Integer id;
	private Integer productid;
	private Integer userid;
	private Integer number;
	private String createdate;
	
	private String title;
	private String imagepath;
	private Integer price;
	private Integer subprice;
	
	private OrderProductBean orderProductBean;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSubprice() {
		return subprice;
	}
	public void setSubprice(Integer subprice) {
		this.subprice = subprice;
	}
	public OrderProductBean getOrderProductBean() {
		return orderProductBean;
	}
	public void setOrderProductBean(OrderProductBean orderProductBean) {
		this.orderProductBean = orderProductBean;
	}
}
