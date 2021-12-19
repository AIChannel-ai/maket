package com.bs.service.impl;

import com.bs.beans.InParams;
import com.bs.beans.MessageBean;
import com.bs.mapper.MessageMapper;
import com.bs.service.IMessageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

	@Resource
	private MessageMapper mapper;

	@Override
	public int insert(MessageBean bean) {
		return mapper.insert(bean);
	}

	@Override
	public int update(MessageBean bean) {
		return mapper.update(bean);
	}

	@Override
	public int delete(@Param("id") Integer id) {
		return mapper.delete(id);
	}

	@Override
	public MessageBean getById(@Param("id") Integer id) {
		return mapper.getById(id);
	}

	@Override
	public List<MessageBean> getAll(@Param("parameter") InParams parameter) {
		return mapper.getAll(parameter);
	}

	@Override
	public int getCount(@Param("parameter") InParams parameter) {
		return mapper.getCount(parameter);
	}

	@Override
	public MessageBean getLastOne() {
		return mapper.getLastOne();
	}

	@Override
	public int update2(MessageBean bean) {
		return mapper.update2(bean);
	}

	@Override
	public int update3(MessageBean bean) {
		return mapper.update3(bean);
	}

	@Override
	public int update4(MessageBean bean) {
		return mapper.update4(bean);
	}

	@Override
	public int update5(MessageBean bean) {
		return mapper.update5(bean);
	}

	@Override
	public int delete2(@Param("parameter") InParams parameter) {
		return mapper.delete2(parameter);
	}

	@Override
	public int delete3(@Param("parameter") InParams parameter) {
		return mapper.delete3(parameter);
	}

	@Override
	public List<MessageBean> getAll2(@Param("parameter") InParams parameter) {
		return mapper.getAll2(parameter);
	}

	@Override
	public List<MessageBean> getAll3(@Param("parameter") InParams parameter) {
		return mapper.getAll3(parameter);
	}

	@Override
	public List<MessageBean> getAll4(@Param("parameter") InParams parameter) {
		return mapper.getAll4(parameter);
	}

	@Override
	public List<MessageBean> getAll5(@Param("parameter") InParams parameter) {
		return mapper.getAll5(parameter);
	}

	@Override
	public MessageBean getOne1(@Param("parameter") InParams parameter) {
		return mapper.getOne1(parameter);
	}

	@Override
	public MessageBean getOne2(@Param("parameter") InParams parameter) {
		return mapper.getOne2(parameter);
	}

	@Override
	public MessageBean getOne3(@Param("parameter") InParams parameter) {
		return mapper.getOne3(parameter);
	}

	@Override
	public MessageBean getOne4(@Param("parameter") InParams parameter) {
		return mapper.getOne4(parameter);
	}

	@Override
	public MessageBean getOne5(@Param("parameter") InParams parameter) {
		return mapper.getOne5(parameter);
	}

	@Override
	public Integer getScalar(@Param("parameter") InParams parameter) {
		return mapper.getScalar(parameter);
	}

	@Override
	public Integer getScalar1(@Param("parameter") InParams parameter) {
		return mapper.getScalar1(parameter);
	}

	@Override
	public Integer getScalar2(@Param("parameter") InParams parameter) {
		return mapper.getScalar2(parameter);
	}

}