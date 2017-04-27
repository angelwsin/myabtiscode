package com.myabtis.generate.Mapper;

import java.io.InputStream;

import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.java.util.ResultType;
import com.myabtis.generate.Mapper.service.GenerateMapperService;
import com.myabtis.generate.Mapper.service.GenerateMapperServiceImpl;
import com.myabtis.generate.request.MapperParamter;
import com.myabtis.generate.request.MapperRequest;
import com.myabtis.generate.request.MapperRequestMethod;
import com.myabtis.generate.result.MapperResult;

public class MapperTest {
    
    
    public static void main(String[] args) throws Exception{
      //配置文件解析
        InputStream is =    Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/myBatis_conf.xml");
        //build 模式  创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =    new SqlSessionFactoryBuilder().build(is);
        GenerateMapperService gen  = new GenerateMapperServiceImpl(sqlSessionFactory);
        MapperRequest request = new MapperRequest();
        request.setBeanName("User");
        request.setBeanPackage("com.java.bean");
        request.setTableName("user");
        request.setMapperPackage("com.java.mapper");
        request.setDaoName("User");
        MapperParamter pa = new MapperParamter();
        pa.put("User", "user");
        MapperRequestMethod method = new MapperRequestMethod(pa,new MapperResult(ResultType.Many, "User"), "getUsers", SqlCommandType.SELECT);
        request.addMapperMethod(method);
        gen.generateMapper(request);
        
        
    }

}
