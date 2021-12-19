package com.bs.service;

import com.bs.beans.CartBean;
import com.bs.beans.InParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICartService {

	public int insert(CartBean bean);

	public int update(CartBean bean);

	public int delete(@Param("id") Integer id);

	public CartBean getById(@Param("id") Integer id);

	public List<CartBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public CartBean getLastOne();

	public int update2(CartBean bean);
	
	public int update3(CartBean bean);
	
	public int update4(CartBean bean);
	
	public int update5(CartBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<CartBean> getAll2(@Param("parameter") InParams parameter);

	public List<CartBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<CartBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<CartBean> getAll5(@Param("parameter") InParams parameter);

	public CartBean getOne1(@Param("parameter") InParams parameter);

	public CartBean getOne2(@Param("parameter") InParams parameter);
	
	public CartBean getOne3(@Param("parameter") InParams parameter);
	
	public CartBean getOne4(@Param("parameter") InParams parameter);
	
	public CartBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
}
