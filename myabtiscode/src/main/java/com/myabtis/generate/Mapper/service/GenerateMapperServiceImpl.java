package com.myabtis.generate.Mapper.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.util.GenBeanFactory;
import com.myabtis.generate.Mapper.MysqlMapper;
import com.myabtis.generate.request.MapperRequest;
import com.myabtis.generate.result.TableColumResult;

public class GenerateMapperServiceImpl implements GenerateMapperService{
    
    private SqlSessionFactory  sqlSessionFactory;
    
    

    public GenerateMapperServiceImpl(SqlSessionFactory sqlSessionFactory) {
        super();
        this.sqlSessionFactory = sqlSessionFactory;
    }



    @Override
    public void generateMapper(MapperRequest request) throws Exception {
       SqlSession session =  sqlSessionFactory.openSession(false);
       MysqlMapper mapper  =  session.getMapper(MysqlMapper.class);
       Connection ps = session.getConnection();
       DatabaseMetaData da = ps.getMetaData();
      
        List<TableColumResult> columResult = mapper.getTableColum(request.getTableName(),
            String.valueOf(SystemMetaObject.forObject(da).getValue("database")));
        request.setColumResult(columResult);
        GenBeanFactory.genBean(request);
        GenBeanFactory.genMapper(request);
    }
    
    

}
