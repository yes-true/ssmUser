package com.usertb.dao.provider;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class RigDaoSqlProvider {
	//多条件使用map 传值
	public String selectByUidOrAid(final Map<String,Integer> map){
		return new SQL(){
			{
				SELECT("r.jurisdiction,r.uid,r.aid");
				FROM("tb_rightcontrol r");

				StringBuilder whereClause = new StringBuilder();
				if (map.get("uid") != null)
					whereClause.append("r.uid = ").append(map.get("uid"));

				if (map.get("aid") != null)
					whereClause.append("r.aid = ").append(map.get("aid"));

				WHERE(whereClause.toString());

			}
		}.toString();
	}

	public String saveRigUserOrAdmin(final Map<String,Integer> map){
		return new SQL(){
			{
				INSERT_INTO("tb_rightcontrol");
				if (map.get("uid") != null){
					VALUES("jurisdiction","1");
					VALUES("uid","#{uid}");
				}
				if (map.get("aid") != null){
					VALUES("jurisdiction","0");
					VALUES("aid","#{aid}");
				}
			}
		}.toString();
	}

}
