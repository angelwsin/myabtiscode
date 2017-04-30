package com.myabtis.generate.Mapper.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.util.GenBeanFactory;
import com.java.util.ResultType;
import com.java.util.StringUtils;
import com.myabtis.generate.Mapper.MysqlMapper;
import com.myabtis.generate.request.MapperRequest;
import com.myabtis.generate.request.MapperRequestBuilder;
import com.myabtis.generate.result.MapperResult;
import com.myabtis.generate.result.TableColumResult;

public class GenerateMapperServiceImpl implements GenerateMapperService{
    
    private SqlSessionFactory  sqlSessionFactory;
    
    

    public GenerateMapperServiceImpl(SqlSessionFactory sqlSessionFactory) {
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
       // Class.forName(request.getMapperPackage());
        GenBeanFactory.genSqlMap(request);
    }



	@Override
	public void generateMapper(MapperRequestBuilder build) throws Exception {
		 SqlSession session =  sqlSessionFactory.openSession(false);
	       MysqlMapper mapper  =  session.getMapper(MysqlMapper.class);
	       Connection ps = session.getConnection();
	       DatabaseMetaData da = ps.getMetaData();
	      
	        List<TableColumResult> columResult = mapper.getTableColum(build.getTableName(),
	        String.valueOf(SystemMetaObject.forObject(da).getValue("database")));
	        String type = getBeanName(build.getBeanPackage());
	        String arg = getBeanArgsName(build.getBeanPackage());
	        MapperRequest req = build.mapperOp("get"+type, SqlCommandType.SELECT)
	        .mapperOpResult(new MapperResult(ResultType.Many, type))
	        .paramter(new String[]{type,arg,"Integer","offset","Integer","rows"})
	        .buildMapperOp()
	        .limit(true)
	        .mapperOp("insert"+type, SqlCommandType.INSERT)
	        .mapperOpResult(new MapperResult(ResultType.One, "int"))
	        .paramter(new String[]{type,arg})
	        .buildMapperOp()
	        .mapperOp("update"+type, SqlCommandType.UPDATE)
	        .mapperOpResult(new MapperResult(ResultType.One, "int"))
	        .paramter(new String[]{type,arg})
	        .buildMapperOp()
	        .mapperOp("get"+type+"ById", SqlCommandType.SELECT)
	        .mapperOpResult(new MapperResult(ResultType.One,type))
	        .paramter(new String[]{"int","id"})
	        .buildMapperOp()
	        .mapperOp("delete"+type+"ById", SqlCommandType.DELETE)
	        .mapperOpResult(new MapperResult(ResultType.One, "int"))
	        .paramter(new String[]{"int","id"})
	        .buildMapperOp()
	        .mapperOp("get"+type+"Count", SqlCommandType.SELECT)
	        .mapperOpResult(new MapperResult(ResultType.One, "long"))
	        .paramter(new String[]{type,arg})
	        .count(true)
	        .buildMapperOp()
	        .buildMapperRequest();
	        req.setColumResult(columResult);
	        GenBeanFactory.genBean(req);
	        GenBeanFactory.genMapper(req);
	       // Class.forName(request.getMapperPackage());
	        GenBeanFactory.genSqlMap(req);
		
	}


	private  String getBeanName(String beanPackage) {
    	Optional<String> op = Optional.of(beanPackage);
    	int index = op.get().lastIndexOf('.');
        return op.get().substring(index+1);
    }
    
    private  String getBeanArgsName(String beanPackage) {
    	Optional<String> op = Optional.of(beanPackage);
    	int index = op.get().lastIndexOf('.');
        return StringUtils.firstCharLowerCase(op.get().substring(index+1));
    }


    
    

}
