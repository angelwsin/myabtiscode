package com.myabtis.generate.request;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.myabtis.generate.result.TableColumResult;

public class MapperRequest {
    
    
    
    private List<MapperRequestMethod> methodes = new ArrayList<MapperRequestMethod>();
    
    private List<TableColumResult> columResult;
   

    private String         tableName;
    
    private String         mapperPackage;
    
    private String         daoName;
    
    private String         beanName;
    
    private String         beanPackage;
    
    private String         sqlMapPath = "src/main/resources/sqlMap";
    
    private String         destPath = System.getProperty("user.dir")+File.separator;

    public String getSqlMapPath() {
        return sqlMapPath;
    }

    public void setSqlMapPath(String sqlMapPath) {
        this.sqlMapPath = sqlMapPath;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getDaoName() {
        return daoName;
    }

    public void setDaoName(String daoName) {
        this.daoName = daoName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanPackage() {
        return beanPackage;
    }

    public void setBeanPackage(String beanPackage) {
        this.beanPackage = beanPackage;
    }

    public List<MapperRequestMethod> getMethodes() {
        return methodes;
    }

    public void setMethodes(List<MapperRequestMethod> methodes) {
        this.methodes = methodes;
    }

    public List<TableColumResult> getColumResult() {
        return columResult;
    }

    public void setColumResult(List<TableColumResult> columResult) {
        this.columResult = columResult;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
    
    
    public List<MapperRequestMethod> addMapperMethod(MapperRequestMethod methode){
        methodes.add(methode);
        return methodes;
    }
    

}
