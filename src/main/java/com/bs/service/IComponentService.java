package com.bs.service;

import com.bs.beans.ComponentBean;
import com.bs.beans.InParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IComponentService {

	public int insert(ComponentBean bean);

	public int update(ComponentBean bean);

	public int delete(@Param("id") Integer id);

	public ComponentBean getById(@Param("id") Integer id);

	public List<ComponentBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public ComponentBean getLastOne();

	public int update2(ComponentBean bean);
	
	public int update3(ComponentBean bean);
	
	public int update4(ComponentBean bean);
	
	public int update5(ComponentBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<ComponentBean> getAll2(@Param("parameter") InParams parameter);

	public List<ComponentBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<ComponentBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<ComponentBean> getAll5(@Param("parameter") InParams parameter);

	public ComponentBean getOne1(@Param("parameter") InParams parameter);

	public ComponentBean getOne2(@Param("parameter") InParams parameter);
	
	public ComponentBean getOne3(@Param("parameter") InParams parameter);
	
	public ComponentBean getOne4(@Param("parameter") InParams parameter);
	
	public ComponentBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
}
