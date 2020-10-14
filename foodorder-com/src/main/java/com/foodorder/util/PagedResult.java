package com.foodorder.util;

import java.io.Serializable;
import java.util.List;

public class PagedResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> result; // 数据

	private long currentPage; // 当前页

	private long pageSize; // 条数

	private long totalCount; // 总条数

	private long totalPage; // 总页面数目

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

}
