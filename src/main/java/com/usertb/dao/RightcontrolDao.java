package com.usertb.dao;

import com.usertb.dao.provider.RigDaoSqlProvider;
import com.usertb.entity.Rightcontrol;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Map;

public interface RightcontrolDao {

	/**
	 * type = 使用该类
	 * method = 该类中的方法
	 * @param map
	 * @return
	 */
	@SelectProvider(type = RigDaoSqlProvider.class, method = "selectByUidOrAid")
	Rightcontrol getRigByUidOrAid(Map<String,Integer> map);

	@InsertProvider(type = RigDaoSqlProvider.class, method = "saveRigUserOrAdmin")
	int saveRigUserOrAdmin(Map<String,Integer> map);
}
