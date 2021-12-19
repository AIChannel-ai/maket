package com.bs.service;

import com.bs.beans.InParams;
import com.bs.beans.OrderProductBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderProductService {

	public int insert(OrderProductBean bean);

	public int update(OrderProductBean bean);

	public int delete(@Param("id") Integer id);

	public OrderProductBean getById(@Param("id") Integer id);

	public List<OrderProductBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public OrderProductBean getLastOne();

	public int update2(OrderProductBean bean);
	
	public int update3(OrderProductBean bean);
	
	public int update4(OrderProductBean bean);
	
	public int update5(OrderProductBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<OrderProductBean> getAll2(@Param("parameter") InParams parameter);

	public List<OrderProductBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<OrderProductBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<OrderProductBean> getAll5(@Param("parameter") InParams parameter);

	public OrderProductBean getOne1(@Param("parameter") InParams parameter);

	public OrderProductBean getOne2(@Param("parameter") InParams parameter);
	
	public OrderProductBean getOne3(@Param("parameter") InParams parameter);
	
	public OrderProductBean getOne4(@Param("parameter") InParams parameter);
	
	public OrderProductBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
}
