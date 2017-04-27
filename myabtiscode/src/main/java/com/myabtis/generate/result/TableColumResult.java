package com.myabtis.generate.result;

public class TableColumResult {
    
    private String columnName;
    
    private String dataType;
    
    private String columnComment;
    
    private int columnType;
    
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

    

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public String getColumnClassName() {
        return columnClassName.replace("java.lang.", "");
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
               + ", columnComment=" + columnComment + ", columnType=" + columnType
               + ", columnClassName=" + columnClassName + "]";
    }

   

}
