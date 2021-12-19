package com.bs.beans;

/**
 * 分页和排序
 * 
 * @author Administrator
 *
 */
public class BaseOrderPages {

	private int pageIndex = 1;
	private int pageSize = 10;
	private int itemTotal;
	
	private  int number;
	
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String orderColumn; // 排序列名
	private String orderMode; // 排序方式

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * mysql limit pageStart and pageSize
	 * @return
	 */
	public int getPageStart() {
		return (pageIndex - 1) * pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * sqlserver limit pageStart2 and pageEnd
	 * @return
	 */
	public int getPageStart2() {
		return (pageIndex - 1) * pageSize + 1;
	}
	public int getPageEnd() {
		return pageIndex * pageSize;
	}
	
	public int getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
}
