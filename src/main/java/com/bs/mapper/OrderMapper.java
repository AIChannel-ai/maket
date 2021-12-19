package com.bs.mapper;

import com.bs.beans.InParams;
import com.bs.beans.OrderBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

	public int insert(OrderBean bean);

	public int update(OrderBean bean);

	public int delete(@Param("id") Integer id);

	public OrderBean getById(@Param("id") Integer id);

	public List<OrderBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public OrderBean getLastOne();

	public int update2(OrderBean bean);
	
	public int update3(OrderBean bean);
	
	public int update4(OrderBean bean);
	
	public int update5(OrderBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<OrderBean> getAll2(@Param("parameter") InParams parameter);

	public List<OrderBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<OrderBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<OrderBean> getAll5(@Param("parameter") InParams parameter);

	public OrderBean getOne1(@Param("parameter") InParams parameter);

	public OrderBean getOne2(@Param("parameter") InParams parameter);
	
	public OrderBean getOne3(@Param("parameter") InParams parameter);
	
	public OrderBean getOne4(@Param("parameter") InParams parameter);
	
	public OrderBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);

}
