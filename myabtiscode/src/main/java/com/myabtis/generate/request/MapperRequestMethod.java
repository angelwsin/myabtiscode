package com.myabtis.generate.request;

import org.apache.ibatis.mapping.SqlCommandType;

import com.myabtis.generate.result.MapperResult;

public class MapperRequestMethod {
    
   private MapperParamter paramter = new MapperParamter();
    
    private MapperResult   result;
    
    private String         methodName;
    
    private SqlCommandType sqlCommandType;
    
    

    public MapperRequestMethod( MapperResult result, String methodName,
                               SqlCommandType sqlCommandType) {
        this.result = result;
        this.methodName = methodName;
        this.sqlCommandType = sqlCommandType;
    }

    public MapperParamter getParamter() {
        return paramter;
    }

    public void setParamter(MapperParamter paramter) {
        this.paramter = paramter;
    }

    public MapperResult getResult() {
        return result;
    }

    public void setResult(MapperResult result) {
        this.result = result;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlCommandType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public MapperRequestMethod putParamter(String paramClass,String argsName){
    	 this.paramter.put(paramClass, argsName);
    	 return this;
    }
    
    
}
