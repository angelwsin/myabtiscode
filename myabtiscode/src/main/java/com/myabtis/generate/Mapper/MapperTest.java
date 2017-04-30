package com.myabtis.generate.Mapper;

import java.io.InputStream;

import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.java.util.ResultType;
import com.myabtis.generate.Mapper.service.GenerateMapperService;
import com.myabtis.generate.Mapper.service.GenerateMapperServiceImpl;
import com.myabtis.generate.request.MapperRequest;
import com.myabtis.generate.request.MapperRequestBuilder;
import com.myabtis.generate.result.MapperResult;

public class MapperTest {
    
    
    public static void main(String[] args) throws Exception{
      //配置文件解析
        InputStream is =    Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/myBatis_gen_conf.xml");
        //build 模式  创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =    new SqlSessionFactoryBuilder().build(is);
        GenerateMapperService gen  = new GenerateMapperServiceImpl(sqlSessionFactory);
      /*  MapperRequest request =MapperRequestBuilder.instance("user", "com.java.bean.User", "com.java.mapper.UserMapper")
        .mapperOp("getUsers", SqlCommandType.SELECT)
        .mapperOpResult(new MapperResult(ResultType.Many, "User"))
        .paramter(new String[]{"User","user","Integer","offset","Integer","rows"})
        .buildMapperOp()
        .limit(true)
        .mapperOp("insertUser", SqlCommandType.INSERT)
        .mapperOpResult(new MapperResult(ResultType.One, "int"))
        .paramter(new String[]{"User","user"})
        .buildMapperOp()
        .mapperOp("updateUser", SqlCommandType.UPDATE)
        .mapperOpResult(new MapperResult(ResultType.One, "int"))
        .paramter(new String[]{"User","user"})
        .buildMapperOp()
        .mapperOp("getUserById", SqlCommandType.SELECT)
        .mapperOpResult(new MapperResult(ResultType.One, "User"))
        .paramter(new String[]{"int","id"})
        .buildMapperOp()
        .mapperOp("deleteUserById", SqlCommandType.DELETE)
        .mapperOpResult(new MapperResult(ResultType.One, "int"))
        .paramter(new String[]{"int","id"})
        .buildMapperOp()
        .mapperOp("getUserCount", SqlCommandType.SELECT)
        .mapperOpResult(new MapperResult(ResultType.One, "long"))
        .paramter(new String[]{"User","user"})
        .count(true)
        .buildMapperOp()
        .buildMapperRequest();
        
        gen.generateMapper(request);*/
        gen.generateMapper(MapperRequestBuilder.instance("users", "com.java.bean.Users", "com.java.mapper.UsersMapper"));
        
    }
	

}
