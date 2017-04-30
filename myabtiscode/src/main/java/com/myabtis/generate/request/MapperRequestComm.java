package com.myabtis.generate.request;

import java.util.HashMap;
import java.util.Map;

import com.java.util.JavaLangType;

public abstract class MapperRequestComm {
	
	  private static Map<String,String>  tableMapField = new HashMap<>();
	  private static  JavaLangType         langType = new JavaLangType();
	    
	  
	  public void put(String field,String colum){
		      tableMapField.put(field, colum);
	  }
	  
	  public  String get(String field){
		     return tableMapField.get(field);
	  }
	  public String getAlias(String key){
	         return langType.getAlias(key);
	    }
	  
	  public boolean isExist(String value){
	        return langType.isExist(value);
	    }

}
