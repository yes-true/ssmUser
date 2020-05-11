package com.usertb.dao;

import com.usertb.entity.Page;
import com.usertb.entity.Rightcontrol;
import com.usertb.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface UserDao {

	/**
      * 定义一个Results
      * id为该Results的名字，可以供其他方法调用
      * value为一个包含Result对象的数组
      * Result的column表示数据表的字段名，
      * property为数据表当前column字段所映射的对象的属性
      * id表示该column该字段是否为主键，默认条件下为非主键
      * one用于表与表之间一对一映射时使用
      * one的select属性，一对一查询所要执行的方法名
      * fetchType表示数据加载形式（FetchType.EAGER表示立即加载，FetchType.LAZY表示懒加载
      */
	@Select("select u.id,u.menbername,u.password,u.phone,u.email,u.atime,u.utime from tb_user u where u.id = ${id}")
	@Results(value = {
		/**
		 * 查询返回数据id为null时，添加id映射
		 */
		@Result(property = "id",column = "id",javaType = Integer.class),
	   /* one to one
		* property 当前表与关联查询表与之对应的属性
		* column 当前表 数据库的字段 多条件时(等号左侧对应java接口的参数，右侧的对应数据库字段名)
		*/
		@Result(property = "rightcontrol", column = "{uid=id}",
		one = @One(select = "com.usertb.dao.RightcontrolDao.getRigByUidOrAid",fetchType = FetchType.LAZY)),

		@Result(property = "sites", column = "id", javaType = List.class,
		many = @Many(select = "com.usertb.dao.SiteDao.listSitesByUid", fetchType = FetchType.LAZY)),

		@Result(property = "datum", column = "id",
		one = @One(select = "com.usertb.dao.DatumDao.getDatumByUid", fetchType = FetchType.LAZY))
	})
	User getUserById(@Param(value = "id") Integer id);

	@Insert("insert into tb_user values (#{id},#{menbername},#{password},#{phone},#{email},#{atime},#{utime})")
	int saveUser(User user);

	@Delete("delete from tb_user where id = #{id} ")
	int deleteUserById(Integer id);

	@Update("update tb_user u set u.password = #{password}, u.phone = #{phone}, u.email = #{email}," +
			"u.utime = #{utime} where u.id = #{id}")
	int updateUser(User user);

	@Select("select id from tb_user where phone = #{phone} or email = #{email} or menbername = #{menbername}")
	Integer getUserByPhoneOrEmailOrmenbername(User user);

	/**
	 * 分页查询 user
	 * select * from 表名 limit 页数*页面大小,页面大小;
	 * @param currentPage 页数*页面大小
	 * @param pageSize 页面大小
	 * @return
	 */
	@Select("select * from tb_user limit ${currentPage},#{pageSize}")
	@Results({
			@Result(property = "id",column = "id",javaType = Integer.class),

			@Result(property = "rightcontrol", column = "{uid=id}",
					one = @One(select = "com.usertb.dao.RightcontrolDao.getRigByUidOrAid",fetchType = FetchType.LAZY)),

			@Result(property = "sites", column = "id", javaType = List.class,
					many = @Many(select = "com.usertb.dao.SiteDao.listSitesByUid", fetchType = FetchType.LAZY)),

			@Result(property = "datum", column = "id",
					one = @One(select = "com.usertb.dao.DatumDao.getDatumByUid", fetchType = FetchType.LAZY))
	})
	List<User> listUser(@Param(value = "currentPage") int currentPage,@Param(value = "pageSize") int pageSize);

	@Select("select count(*) from tb_user")
	int getUsers();

}
