package com.myabtis.generate.request;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ibatis.mapping.SqlCommandType;

import com.myabtis.generate.result.MapperResult;

public class MapperRequestBuilder {
	
	  private static MapperRequestBuilder   builder= new MapperRequestBuilder();
	  private MapperRequestBuilder(){
		  
	  }
	  
	  private String         tableName;
	  private String         mapperPackage;
	    
	    private String         beanPackage;
	    private Map<String,MapperRequestMethod> mds = new HashMap<>();
	    private MapperRequestMethod    currentMethod ;
	  
	  public static MapperRequestBuilder instance(String tableName,String beanPackage,String mapperPackage){
		  builder.tableName = tableName;
		  builder.mapperPackage = mapperPackage;
		  builder.beanPackage = beanPackage;
		         return builder;
	  }
	
	 
	 public   MapperRequestBuilder mapperOp(String methodName, SqlCommandType cmdType){
		       if(mds.containsKey(methodName))  throw new RuntimeException(methodName+"方法已经存在");
		         currentMethod = new MapperRequestMethod(methodName, cmdType); 
		         return builder;
	 }
	 public MapperRequestBuilder  mapperOpResult(MapperResult   result){
		 currentMethod.setResult(result);
		 return builder;
	 }
	 public MapperRequestBuilder   paramter(String[] param){
		    if(param.length%2!=0) throw new RuntimeException("方法参数错误");
		    for(int i=0;i<param.length;i=i+2){
		    	 currentMethod.putParamter(param[i], param[i+1]);
		    }
		    return builder;
	 }
	 public MapperRequestBuilder   limit(boolean limit){
		    currentMethod.setLimit(limit);
		    return builder;
	 }
	 public MapperRequestBuilder   count(boolean count){
		    currentMethod.setCount(count);
		    return builder;
	 }
	 
	 public MapperRequestBuilder buildMapperOp(){
		 mds.put(currentMethod.getMethodName(), currentMethod);
		 return builder;
	 } 
	 
	 public MapperRequest buildMapperRequest(){
		 MapperRequest req = new MapperRequest();
		 req.setBeanPackage(beanPackage);
		 req.setMapperPackage(mapperPackage);
		 req.setTableName(tableName);
		 req.setMethodes( mds.values().stream().collect(Collectors.toList()));
		 return req;
	 }


	public String getTableName() {
		return tableName;
	}


	public String getBeanPackage() {
		return beanPackage;
	}


	public void setBeanPackage(String beanPackage) {
		this.beanPackage = beanPackage;
	}
	  
	  

}
