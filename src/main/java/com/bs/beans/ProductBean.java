package com.bs.beans;

public class ProductBean extends ABaseBean {
	
	private Integer id;
	private String title;
	private String productcode;
	private Integer categoryid;
	private String intro;
	private Integer oldprice;
	private Integer price;
	private Integer number;
	private String imagepath;
	private String createdate;
	private Integer userid;
	private String status;
	private Integer newest;
	private Integer hottest;
	private Integer recommend;
	
	private String categoryname;
	private Integer saleAllNumber;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public Integer getOldprice() {
		return oldprice;
	}
	public void setOldprice(Integer oldprice) {
		this.oldprice = oldprice;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNewest() {
		return newest;
	}
	public void setNewest(Integer newest) {
		this.newest = newest;
	}
	public Integer getHottest() {
		return hottest;
	}
	public void setHottest(Integer hottest) {
		this.hottest = hottest;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Integer getSaleAllNumber() {
		return saleAllNumber;
	}
	public void setSaleAllNumber(Integer saleAllNumber) {
		this.saleAllNumber = saleAllNumber;
	}
	
}
