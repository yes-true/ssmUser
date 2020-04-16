package com.usertb.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ConnTest {

	@Autowired
	private ComboPooledDataSource dataSource;

	@Test
	public void conn() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("connection = " + connection);
	}

}
