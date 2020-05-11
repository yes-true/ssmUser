package com.usertb.entity;

import java.util.List;

/**
 * 分页工具类
 */
public class Page {
	/**
	 * 当前页数
	 */
	private int currentPage;
	/**
	 * 总页数
	 */
	private int totalPages;
	/**
	 * 总数据
	 */
	private int totalUsers;
	/**
	 * 每页行数
	 */
	private int pageSize;
	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 前一页
	 */
	private int prefPage;
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * 输出当前页面
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 设置当前页面
	 * @return
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 输出总页面
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/* 总页面自动计算
	 * public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
	 */
	/**
	 * 输出总数据量
	 * @return
	 */
	public int getTotalUsers() {
		return totalUsers;
	}
	/**
	 * 设置总数据量
	 * @return
	 */
	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}
	/**
	 * 输出每页行数
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 设置每页行数
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		//总页面 = 总数据%每页显示行数==0？总数据/每页显示行数：总数据/每页显示行数+1
		totalPages = totalUsers%this.pageSize == 0 ? totalUsers/this.pageSize : totalUsers/this.pageSize+1;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrefPage() {
		return prefPage;
	}
	public void setPrefPage(int prefPage) {
		this.prefPage = prefPage;
	}
}
