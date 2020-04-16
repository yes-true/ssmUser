package com.usertb.dao;

import com.usertb.entity.Site;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SiteDao {

	@Select(value = {"select s.id,s.uid,s.mailbox,s.address,s.phone,s.name from tb_site s where s.uid = #{uid}"})
	List<Site> listSitesByUid(Integer uid);

	@Insert(value = "insert into tb_site values (#{id},#{uid},#{mailbox},#{address},#{phone},#{name})")
	int saveSite(Site site);

	@Delete("delete from tb_site where id = #{id}")
	int deleteSite(Integer id);

	@Update("update tb_site set mailbox = #{mailbox}, address = #{address}, phone = #{phone}, name = #{name} " +
			"where id = #{id}")
	int updateSite(Site site);

}
