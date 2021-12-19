package com.bs.mapper;

import com.bs.beans.InParams;
import com.bs.beans.MessageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {

	public int insert(MessageBean bean);

	public int update(MessageBean bean);

	public int delete(@Param("id") Integer id);

	public MessageBean getById(@Param("id") Integer id);

	public List<MessageBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public MessageBean getLastOne();

	public int update2(MessageBean bean);

	public int update3(MessageBean bean);

	public int update4(MessageBean bean);

	public int update5(MessageBean bean);

	public int delete2(@Param("parameter") InParams parameter);

	public int delete3(@Param("parameter") InParams parameter);

	public List<MessageBean> getAll2(@Param("parameter") InParams parameter);

	public List<MessageBean> getAll3(@Param("parameter") InParams parameter);

	public List<MessageBean> getAll4(@Param("parameter") InParams parameter);

	public List<MessageBean> getAll5(@Param("parameter") InParams parameter);

	public MessageBean getOne1(@Param("parameter") InParams parameter);

	public MessageBean getOne2(@Param("parameter") InParams parameter);

	public MessageBean getOne3(@Param("parameter") InParams parameter);

	public MessageBean getOne4(@Param("parameter") InParams parameter);

	public MessageBean getOne5(@Param("parameter") InParams parameter);

	public Integer getScalar(@Param("parameter") InParams parameter);

	public Integer getScalar1(@Param("parameter") InParams parameter);

	public Integer getScalar2(@Param("parameter") InParams parameter);

}