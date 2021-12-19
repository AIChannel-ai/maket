package com.bs.beans;

public class OrderProductBean extends ABaseBean {
	
	private Integer id;
	private Integer orderid;
	private Integer productid;
	private Integer number;
	
	private String title;
	private Integer price;
	private Integer subprice;
	private String imagepath;
	private String createdate;
	
	public OrderProductBean() {
	
	}
	
	public OrderProductBean(Integer productid, Integer number) {
		super();
		this.productid = productid;
		this.number = number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
