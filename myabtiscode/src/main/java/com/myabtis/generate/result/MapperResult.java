package com.myabtis.generate.result;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;

import com.java.util.ResultType;

public class MapperResult{
    
    
    
    public MapperResult(ResultType resultType) {
        this.resultType = resultType;
    }

    
    public MapperResult(ResultType resultType, String keyClass, String valueClass) {
        this.resultType = resultType;
        this.keyClass = keyClass;
        this.valueClass = valueClass;
    }

    

    public MapperResult(ResultType resultType, String valueClass) {
        this.resultType = resultType;
        this.valueClass = valueClass;
    }



    private ResultType resultType;
    
    private String   keyClass;
    
    private String    valueClass;
    

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }
    
    
    
    public String getKeyClass() {
        return keyClass;
    }

    public void setKeyClass(String keyClass) {
        this.keyClass = keyClass;
    }

    public String getValueClass() {
        return valueClass;
    }

    public void setValueClass(String valueClass) {
        this.valueClass = valueClass;
    }

  
    public String getResultStr() {
		switch (resultType) {
		case Void:

			return "Void";
		case Many:

			return String.format("List<%s>", valueClass);
		case Map:

			return String.format("Map<%s,%s>", keyClass, valueClass);
		case Cursor:

			return String.format("Cursor<%s>", valueClass);
		case One:

			return valueClass;
		}
		return "void";
    }
    
    public String getResultImport() {
		switch (resultType) {
		case Void:

			return "Void";
		case Many:

			return List.class.getName();
		case Map:

			return Map.class.getName();
		case Cursor:

			return Cursor.class.getName();
		case One:

			return valueClass;
		}
		return "void";
    }

    
    public static void main(String[] args) throws Exception{
           String clazz = "User";
           Class.forName(clazz);
    }
    
    

}
