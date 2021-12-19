package com.bs.service.impl;

import com.bs.beans.InParams;
import com.bs.beans.OrderProductBean;
import com.bs.mapper.OrderProductMapper;
import com.bs.service.IOrderProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderProductServiceImpl implements IOrderProductService {

	@Resource
	private OrderProductMapper mapper;

	@Override
	public int insert(OrderProductBean bean) {
		return mapper.insert(bean);
	}

	@Override
	public int update(OrderProductBean bean) {
		return mapper.update(bean);
	}

	@Override
	public int delete(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public OrderProductBean getById(Integer id) {
		return mapper.getById(id);
	}

	@Override
	public List<OrderProductBean> getAll(InParams parameter) {
		return mapper.getAll(parameter);
	}

	@Override
	public int getCount(InParams parameter) {
		return mapper.getCount(parameter);
	}

	@Override
	public OrderProductBean getLastOne() {
		return mapper.getLastOne();
	}

	@Override
	public int update2(OrderProductBean bean) {
		return mapper.update2(bean);
	}

	@Override
	public int update3(OrderProductBean bean) {
		return mapper.update3(bean);
	}

	@Override
	public int update4(OrderProductBean bean) {
		return mapper.update4(bean);
	}

	@Override
	public int update5(OrderProductBean bean) {
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
	public List<OrderProductBean> getAll2(InParams parameter) {
		return mapper.getAll2(parameter);
	}

	@Override
	public List<OrderProductBean> getAll3(InParams parameter) {
		return mapper.getAll3(parameter);
	}

	@Override
	public List<OrderProductBean> getAll4(InParams parameter) {
		return mapper.getAll4(parameter);
	}

	@Override
	public List<OrderProductBean> getAll5(InParams parameter) {
		return mapper.getAll5(parameter);
	}

	@Override
	public OrderProductBean getOne1(InParams parameter) {
		return mapper.getOne1(parameter);
	}

	@Override
	public OrderProductBean getOne2(InParams parameter) {
		return mapper.getOne2(parameter);
	}

	@Override
	public OrderProductBean getOne3(InParams parameter) {
		return mapper.getOne3(parameter);
	}

	@Override
	public OrderProductBean getOne4(InParams parameter) {
		return mapper.getOne4(parameter);
	}

	@Override
	public OrderProductBean getOne5(InParams parameter) {
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
