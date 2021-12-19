package com.bs.service.impl;

import com.bs.beans.CartBean;
import com.bs.beans.InParams;
import com.bs.mapper.CartMapper;
import com.bs.service.ICartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

	@Resource
	private CartMapper mapper;

	@Override
	public int insert(CartBean bean) {
		return mapper.insert(bean);
	}

	@Override
	public int update(CartBean bean) {
		return mapper.update(bean);
	}

	@Override
	public int delete(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public CartBean getById(Integer id) {
		return mapper.getById(id);
	}

	@Override
	public List<CartBean> getAll(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll(parameter);
	}

	@Override
	public int getCount(InParams parameter) {
		return mapper.getCount(parameter);
	}

	@Override
	public CartBean getLastOne() {
		return mapper.getLastOne();
	}

	@Override
	public int update2(CartBean bean) {
		return mapper.update2(bean);
	}

	@Override
	public int update3(CartBean bean) {
		return mapper.update3(bean);
	}

	@Override
	public int update4(CartBean bean) {
		return mapper.update4(bean);
	}

	@Override
	public int update5(CartBean bean) {
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
	public List<CartBean> getAll2(InParams parameter) {
		return mapper.getAll2(parameter);
	}

	@Override
	public List<CartBean> getAll3(InParams parameter) {
		return mapper.getAll3(parameter);
	}

	@Override
	public List<CartBean> getAll4(InParams parameter) {
		return mapper.getAll4(parameter);
	}

	@Override
	public List<CartBean> getAll5(InParams parameter) {
		return mapper.getAll5(parameter);
	}

	@Override
	public CartBean getOne1(InParams parameter) {
		return mapper.getOne1(parameter);
	}

	@Override
	public CartBean getOne2(InParams parameter) {
		return mapper.getOne2(parameter);
	}

	@Override
	public CartBean getOne3(InParams parameter) {
		return mapper.getOne3(parameter);
	}

	@Override
	public CartBean getOne4(InParams parameter) {
		return mapper.getOne4(parameter);
	}

	@Override
	public CartBean getOne5(InParams parameter) {
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
