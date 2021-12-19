package com.bs.service;

import com.bs.beans.InParams;
import com.bs.beans.ProductBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {

	public int insert(ProductBean bean);

	public int update(ProductBean bean);

	public int delete(@Param("id") Integer id);

	public ProductBean getById(@Param("id") Integer id);

	public List<ProductBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public ProductBean getLastOne();

	public int update2(ProductBean bean);
	
	public int update3(ProductBean bean);
	
	public int update4(ProductBean bean);
	
	public int update5(ProductBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<ProductBean> getAll2(@Param("parameter") InParams parameter);

	public List<ProductBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<ProductBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<ProductBean> getAll5(@Param("parameter") InParams parameter);

	public ProductBean getOne1(@Param("parameter") InParams parameter);

	public ProductBean getOne2(@Param("parameter") InParams parameter);
	
	public ProductBean getOne3(@Param("parameter") InParams parameter);
	
	public ProductBean getOne4(@Param("parameter") InParams parameter);
	
	public ProductBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
}
