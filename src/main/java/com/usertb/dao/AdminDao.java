package com.usertb.dao;

import com.usertb.entity.Admin;
import org.apache.ibatis.annotations.*;

public interface AdminDao {

	@Select("select a.id,a.email,a.phone,a.password,a.atime,a.utime from tb_admin a where a.id = #{id}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "rightcontrol", column = "{aid=id}",
			one = @One(select = "com.usertb.dao.RightcontrolDao.getRigByUidOrAid"))
	})
	Admin getAdminById(Integer id);

	@Insert("insert into tb_admin values (#{id},#{email},#{phone},#{password},#{atime},#{utime})")
	int saveAdmin(Admin admin);

	@Delete("delete from tb_admin where id = #{id}")
	int deleteAdmin(Integer id);

	@Update("update tb_admin set email = #{email}, phone = #{phone}, password = #{password}, utime = #{utime}")
	int updateAdmin();

	@Select("select id from tb_admin where phone = #{phone} or email = #{email}")
	Integer queryAdminByPhoneOrEmailAndPassword(Admin admin);
}
