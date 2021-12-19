package com.bs.service;

import com.bs.beans.CommentBean;
import com.bs.beans.InParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentService {

	public int insert(CommentBean bean);

	public int update(CommentBean bean);

	public int delete(@Param("id") Integer id);

	public CommentBean getById(@Param("id") Integer id);

	public List<CommentBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public CommentBean getLastOne();

	public int update2(CommentBean bean);
	
	public int update3(CommentBean bean);
	
	public int update4(CommentBean bean);
	
	public int update5(CommentBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<CommentBean> getAll2(@Param("parameter") InParams parameter);

	public List<CommentBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<CommentBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<CommentBean> getAll5(@Param("parameter") InParams parameter);

	public CommentBean getOne1(@Param("parameter") InParams parameter);

	public CommentBean getOne2(@Param("parameter") InParams parameter);
	
	public CommentBean getOne3(@Param("parameter") InParams parameter);
	
	public CommentBean getOne4(@Param("parameter") InParams parameter);
	
	public CommentBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
}
