package com.myabtis.generate.page;

import java.util.List;

public interface UserService<T> {
	 default Paging<T>   paging(T condition,int pageNum,int pageSize){
	        Paging<T>  pg = new Paging<>();
	        pg.setData(getByCondition(condition, pageNum*pageSize, pageSize));
	        pg.setCurPage(pageNum);
	        pg.setTotalRecode(getByConditonCount(condition));
	        pg.setPageSize(pageSize);
	       return pg;
}
List<T>     getByCondition(T condition,int offset,int rows);
long          getByConditonCount(T condition);

}
