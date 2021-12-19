package com.bs.service.impl;

import com.bs.beans.InParams;
import com.bs.beans.UserBean;
import com.bs.mapper.UserMapper;
import com.bs.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper mapper;

	@Override
	public int insert(UserBean bean) {
		return mapper.insert(bean);
	}

	@Override
	public int update(UserBean bean) {
		return mapper.update(bean);
	}

	@Override
	public int delete(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public UserBean getById(Integer id) {
		return mapper.getById(id);
	}

	@Override
	public List<UserBean> getAll(InParams parameter) {
		parameter.setItemTotal(getCount(parameter));
		return mapper.getAll(parameter);
	}

	@Override
	public int getCount(InParams parameter) {
		return mapper.getCount(parameter);
	}

	@Override
	public UserBean getLastOne() {
		return mapper.getLastOne();
	}

	@Override
	public int update2(UserBean bean) {
		return mapper.update2(bean);
	}

	@Override
	public int update3(UserBean bean) {
		return mapper.update3(bean);
	}

	@Override
	public int update4(UserBean bean) {
		return mapper.update4(bean);
	}

	@Override
	public int update5(UserBean bean) {
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
	public List<UserBean> getAll2(InParams parameter) {
		return mapper.getAll2(parameter);
	}

	@Override
	public List<UserBean> getAll3(InParams parameter) {
		return mapper.getAll3(parameter);
	}

	@Override
	public List<UserBean> getAll4(InParams parameter) {
		return mapper.getAll4(parameter);
	}

	@Override
	public List<UserBean> getAll5(InParams parameter) {
		return mapper.getAll5(parameter);
	}

	@Override
	public UserBean getOne1(InParams parameter) {
		return mapper.getOne1(parameter);
	}

	@Override
	public UserBean getOne2(InParams parameter) {
		return mapper.getOne2(parameter);
	}

	@Override
	public UserBean getOne3(InParams parameter) {
		return mapper.getOne3(parameter);
	}

	@Override
	public UserBean getOne4(InParams parameter) {
		return mapper.getOne4(parameter);
	}

	@Override
	public UserBean getOne5(InParams parameter) {
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
	
	@Override
	public UserBean login(String username, String password, String usertype) {
		return mapper.login(username, password, usertype);
	}

	@Override
	public int saveMyInfo(UserBean user) {
		return mapper.saveMyInfo(user);
	}

	@Override
	public int checkStatus(UserBean user) {
		return mapper.checkStatus(user);
	}

	@Override
	public int modifyPwd(Integer id, String password) {
		return mapper.modifyPwd(id, password);
	}

	@Override
	public int calcScore(Integer id, Integer sorce) {
		return mapper.calcScore(id, sorce);
	}
}
