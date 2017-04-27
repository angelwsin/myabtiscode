package com.myabtis.generate.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.myabtis.generate.result.TableColumResult;

public interface MysqlMapper {
    
    
     
    
     @Select("select column_name columnName,data_type dataType,column_comment columnComment from information_schema.columns where table_name =#{tableName}  and table_schema =#{schema}")
     @ResultType(TableColumResult.class)
     public List<TableColumResult>   getTableColum(@Param("tableName")String tableName,@Param("schema")String schema);
     
    

}
