package com.myabtis.generate.page;

import java.util.List;

public class Paging<T> {
	
	  private  List<T>   data;
	  private  int curPage;
	  private int  pageSize = 10;
	  private  long totalRecode;
   
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public long getTotalPage() {
		long pg = totalRecode/pageSize;
		return totalRecode%pageSize==0?pg:(pg+1);
	}
	
	public long getTotalRecode() {
		return totalRecode;
	}
	public void setTotalRecode(long totalRecode) {
		this.totalRecode = totalRecode;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	  
	  
	  

}
