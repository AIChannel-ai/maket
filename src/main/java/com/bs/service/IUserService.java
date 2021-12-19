package com.bs.service;

import com.bs.beans.InParams;
import com.bs.beans.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {

	public int insert(UserBean bean);

	public int update(UserBean bean);

	public int delete(@Param("id") Integer id);

	public UserBean getById(@Param("id") Integer id);

	public List<UserBean> getAll(@Param("parameter") InParams parameter);

	public int getCount(@Param("parameter") InParams parameter);

	public UserBean getLastOne();

	public int update2(UserBean bean);
	
	public int update3(UserBean bean);
	
	public int update4(UserBean bean);
	
	public int update5(UserBean bean);
	
	public int delete2(@Param("parameter") InParams parameter);
	
	public int delete3(@Param("parameter") InParams parameter);
	
	public List<UserBean> getAll2(@Param("parameter") InParams parameter);

	public List<UserBean> getAll3(@Param("parameter") InParams parameter);
	
	public List<UserBean> getAll4(@Param("parameter") InParams parameter);
	
	public List<UserBean> getAll5(@Param("parameter") InParams parameter);

	public UserBean getOne1(@Param("parameter") InParams parameter);

	public UserBean getOne2(@Param("parameter") InParams parameter);
	
	public UserBean getOne3(@Param("parameter") InParams parameter);
	
	public UserBean getOne4(@Param("parameter") InParams parameter);
	
	public UserBean getOne5(@Param("parameter") InParams parameter);
	
	public Integer getScalar(@Param("parameter") InParams parameter);
	
	public Integer getScalar1(@Param("parameter") InParams parameter);
	
	public Integer getScalar2(@Param("parameter") InParams parameter);
	
	public UserBean login(@Param("username") String username, @Param("password") String password,
			@Param("usertype") String usertype);

	public int saveMyInfo(UserBean user);

	public int checkStatus(UserBean user);

	public int modifyPwd(@Param("id") Integer id, @Param("password") String password);

	public int calcScore(@Param("id") Integer id, @Param("sorce") Integer sorce);

}
