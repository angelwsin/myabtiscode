package com.myabtis.generate.result;

import com.java.util.StringUtils;


public class TableColumResult {
    
    private final static String auto_increment = "auto_increment";
    
    private String columnName;
    
    private String dataType;
    
    private String columnComment;
    
    private int columnType;
    
    private String extra;
    
    private String columnClassName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getFieldName(){
        return StringUtils.getTableColField(this.columnName);
    }
    
    
    public String getMethodName(){
        return StringUtils.getTableNameClass(this.columnName);
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public String getColumnClassName() {
        return this.columnClassName;
    }
    
    public String getColumnClass(){
        Class<?> clazz = null ;
        try {
          clazz=   Class.forName(this.columnClassName);
        } catch (ClassNotFoundException e) {
            return this.columnClassName;
        }
    	return clazz.getSimpleName();
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

    
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    

    @Override
    public String toString() {
        return "TableColumResult [columnName=" + columnName + ", dataType=" + dataType
               + ", columnComment=" + columnComment + ", columnType=" + columnType + ", extra="
               + extra + ", columnClassName=" + columnClassName + "]";
    }

    public static void main(String[] args)throws Exception {
        
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
    public boolean isAutoInc(){
         return auto_increment.equals(this.extra);
    }
   

}
