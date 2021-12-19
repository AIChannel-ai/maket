package com.bs.service.impl;

import com.bs.beans.ComponentBean;
import com.bs.beans.InParams;
import com.bs.mapper.ComponentMapper;
import com.bs.service.IComponentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComponentServiceImpl implements IComponentService {

	@Resource
	private ComponentMapper mapper;

	@Override
	public int insert(ComponentBean bean) {
		return mapper.insert(bean);
	}

	@Override
	public int update(ComponentBean bean) {
		return mapper.update(bean);
	}

	@Override
	public int delete(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public ComponentBean getById(Integer id) {
		return mapper.getById(id);
	}

	@Override
	public List<ComponentBean> getAll(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll(parameter);
	}

	@Override
	public int getCount(InParams parameter) {
		return mapper.getCount(parameter);
	}

	@Override
	public ComponentBean getLastOne() {
		return mapper.getLastOne();
	}

	@Override
	public int update2(ComponentBean bean) {
		return mapper.update2(bean);
	}

	@Override
	public int update3(ComponentBean bean) {
		return mapper.update3(bean);
	}

	@Override
	public int update4(ComponentBean bean) {
		return mapper.update4(bean);
	}

	@Override
	public int update5(ComponentBean bean) {
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
	public List<ComponentBean> getAll2(InParams parameter) {
		return mapper.getAll2(parameter);
	}

	@Override
	public List<ComponentBean> getAll3(InParams parameter) {
		return mapper.getAll3(parameter);
	}

	@Override
	public List<ComponentBean> getAll4(InParams parameter) {
		return mapper.getAll4(parameter);
	}

	@Override
	public List<ComponentBean> getAll5(InParams parameter) {
		return mapper.getAll5(parameter);
	}

	@Override
	public ComponentBean getOne1(InParams parameter) {
		return mapper.getOne1(parameter);
	}

	@Override
	public ComponentBean getOne2(InParams parameter) {
		return mapper.getOne2(parameter);
	}

	@Override
	public ComponentBean getOne3(InParams parameter) {
		return mapper.getOne3(parameter);
	}

	@Override
	public ComponentBean getOne4(InParams parameter) {
		return mapper.getOne4(parameter);
	}

	@Override
	public ComponentBean getOne5(InParams parameter) {
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
