package com.bs.service.impl;

import com.bs.beans.InParams;
import com.bs.beans.ProductBean;
import com.bs.mapper.ProductMapper;
import com.bs.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

	@Resource
	private ProductMapper mapper;

	@Override
	public int insert(ProductBean bean) {
		return mapper.insert(bean);
	}

	@Override
	public int update(ProductBean bean) {
		return mapper.update(bean);
	}

	@Override
	public int delete(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public ProductBean getById(Integer id) {
		return mapper.getById(id);
	}

	@Override
	public List<ProductBean> getAll(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll(parameter);
	}

	@Override
	public int getCount(InParams parameter) {
		return mapper.getCount(parameter);
	}

	@Override
	public ProductBean getLastOne() {
		return mapper.getLastOne();
	}

	@Override
	public int update2(ProductBean bean) {
		return mapper.update2(bean);
	}

	@Override
	public int update3(ProductBean bean) {
		return mapper.update3(bean);
	}

	@Override
	public int update4(ProductBean bean) {
		return mapper.update4(bean);
	}

	@Override
	public int update5(ProductBean bean) {
		return mapper.update5(bean);
	}

	@Override
	public int delete2(InParams parameter) {
		return mapper.delete2(parameter);
	}

	@Override
	public int delete3(InParams parameter) {
		return mapper.delete3(parameter);
	}

	@Override
	public List<ProductBean> getAll2(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll2(parameter);
	}

	@Override
	public List<ProductBean> getAll3(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll3(parameter);
	}

	@Override
	public List<ProductBean> getAll4(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll4(parameter);
	}

	@Override
	public List<ProductBean> getAll5(InParams parameter) {
		return mapper.getAll5(parameter);
	}

	@Override
	public ProductBean getOne1(InParams parameter) {
		return mapper.getOne1(parameter);
	}

	@Override
	public ProductBean getOne2(InParams parameter) {
		return mapper.getOne2(parameter);
	}

	@Override
	public ProductBean getOne3(InParams parameter) {
		return mapper.getOne3(parameter);
	}

	@Override
	public ProductBean getOne4(InParams parameter) {
		return mapper.getOne4(parameter);
	}

	@Override
	public ProductBean getOne5(InParams parameter) {
		return mapper.getOne5(parameter);
	}

	@Override
	public Integer getScalar(InParams parameter) {
		return mapper.getScalar(parameter);
	}

	@Override
	public Integer getScalar1(InParams parameter) {
		return mapper.getScalar1(parameter);
	}

	@Override
	public Integer getScalar2(InParams parameter) {
		return mapper.getScalar2(parameter);
	}
}
