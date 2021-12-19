package com.bs.beans;

import java.util.List;

public class OrderBean extends ABaseBean {
	
	private Integer id;
	private String ordercode;
	private String ordername;
	private Integer sumprice;
	private String createdate;
	private Integer sorce;
	private String status;
	private String address;
	private String paytype;
	private Integer userid;
	
	private List<OrderProductBean> orderProduct;
	private String username;
	private Integer number;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public Integer getSumprice() {
		return sumprice;
	}
	public void setSumprice(Integer sumprice) {
		this.sumprice = sumprice;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public Integer getSorce() {
		return sorce;
	}
	public void setSorce(Integer sorce) {
		this.sorce = sorce;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public List<OrderProductBean> getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(List<OrderProductBean> orderProduct) {
		this.orderProduct = orderProduct;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
