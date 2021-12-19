package com.bs.service;

import com.bs.beans.CategoryBean;
import com.bs.beans.InParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryService {

	public int insert(CategoryBean bean);

	public int update(CategoryBean bean);

	public int delete(@Param("id") Integer id);

	public CategoryBean getById(@Param("id") Integer id);

	public List<CategoryBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public CategoryBean getLastOne();

	public int update2(CategoryBean bean);
	
	public int update3(CategoryBean bean);
	
	public int update4(CategoryBean bean);
	
	public int update5(CategoryBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<CategoryBean> getAll2(@Param("parameter") InParams parameter);

	public List<CategoryBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<CategoryBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<CategoryBean> getAll5(@Param("parameter") InParams parameter);

	public CategoryBean getOne1(@Param("parameter") InParams parameter);

	public CategoryBean getOne2(@Param("parameter") InParams parameter);
	
	public CategoryBean getOne3(@Param("parameter") InParams parameter);
	
	public CategoryBean getOne4(@Param("parameter") InParams parameter);
	
	public CategoryBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
}
