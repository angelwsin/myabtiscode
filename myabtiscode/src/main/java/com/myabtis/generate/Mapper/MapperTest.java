package com.myabtis.generate.Mapper;

import java.io.InputStream;

import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.java.util.ResultType;
import com.myabtis.generate.Mapper.service.GenerateMapperService;
import com.myabtis.generate.Mapper.service.GenerateMapperServiceImpl;
import com.myabtis.generate.request.MapperRequest;
import com.myabtis.generate.request.MapperRequestMethod;
import com.myabtis.generate.result.MapperResult;

public class MapperTest {
    
    
    public static void main(String[] args) throws Exception{
      //配置文件解析
        InputStream is =    Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/myBatis_gen_conf.xml");
        //build 模式  创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =    new SqlSessionFactoryBuilder().build(is);
        GenerateMapperService gen  = new GenerateMapperServiceImpl(sqlSessionFactory);
        MapperRequest request = new MapperRequest();
        request.setBeanPackage("com.java.bean.User");
        request.setTableName("user");
        request.setMapperPackage("com.java.mapper.UserMapper");
        MapperRequestMethod method = new MapperRequestMethod(new MapperResult(ResultType.Many, "User"), "getUsers", SqlCommandType.SELECT);
        method.putParamter("User", "user");
        request.addMapperMethod(method);
        MapperRequestMethod insert = new MapperRequestMethod(new MapperResult(ResultType.One, "int"), "insertUser", SqlCommandType.INSERT);
        insert.putParamter("User", "user");
        request.addMapperMethod(insert);
        MapperRequestMethod update = new MapperRequestMethod(new MapperResult(ResultType.One, "int"), "updateUser", SqlCommandType.UPDATE);
        update.putParamter("User", "user");
        request.addMapperMethod(update);
        MapperRequestMethod one = new MapperRequestMethod(new MapperResult(ResultType.One, "User"), "getUserById", SqlCommandType.SELECT);
        one.putParamter("int", "id");
        request.addMapperMethod(one);
        gen.generateMapper(request);
        
        
    }

}
