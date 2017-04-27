package com.myabtis.generate.request;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.myabtis.generate.result.TableColumResult;

public class MapperRequest {
    
    
    
    private List<MapperRequestMethod> methodes = new ArrayList<MapperRequestMethod>();
    
    private List<TableColumResult> columResult;
   

    private String         tableName;
    
    private String         mapperPackage;
    
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
    	Optional<String> op = Optional.of(this.mapperPackage);
    	int index = op.get().lastIndexOf('.');
        return op.get().substring(index+1);
    }

  
    public String getBeanName() {
    	Optional<String> op = Optional.of(this.beanPackage);
    	int index = op.get().lastIndexOf('.');
        return op.get().substring(index+1);
    }
    
    public String getBeanImportPackage() {
    	Optional<String> op = Optional.of(this.beanPackage);
    	int index = op.get().lastIndexOf('.');
        return op.get().substring(0,index);
    }
    public  Set<String> getBeanImportsPackage() {
    	 Set<String> imports = new HashSet<>();
    	 columResult.stream().forEach(res->{
    		  if(!res.getColumnClass().contains("java.lang.")){
    			  imports.add(res.getColumnClass());
    		  }
    	 });
    	return imports;
    }

    public Set<String> getMapperImportsPackage() {
    	 Set<String> imports = new HashSet<>();
    	 imports.add(this.beanPackage);
    	 methodes.stream().forEach(methods->{
    		 if(StringUtils.isNotEmpty(methods.getResult().getResultImport())){
    			 imports.add(methods.getResult().getResultImport());
    		 }
    	 });
    	 return imports;
    }
    public String getMapperImportPackage() {
    	Optional<String> op = Optional.of(this.mapperPackage);
    	int index = op.get().lastIndexOf('.');
        return op.get().substring(0,index);
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
