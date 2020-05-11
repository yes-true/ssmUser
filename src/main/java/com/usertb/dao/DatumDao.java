package com.usertb.dao;

import com.usertb.entity.Datum;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DatumDao {

	@Select("select d.uid,d.phone,d.name,d.gender,d.photo,d.birthday from tb_datum d where d.uid = #{uid}")
	Datum getDatumByUid(Integer id);

	@Insert("insert into tb_datum values (#{uid},#{phone},#{name},#{gender},#{birthday},#{photo})")
	int saveDatum(Datum datum);

	@Update("update tb_datum set phone = #{phone}, name = #{name}, gender = #{gender}, birthday = #{birthday}" +
			" where uid = #{uid}")
	int updateDatum(Datum datum);

	@Update("update tb_datum set photo = #{photo} where uid = #{id}")
	int updatePhoto(@Param("photo") String photo,@Param("id") int id);
}
