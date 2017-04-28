package com.myabtis.generate.interceptor;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.util.CaseUtils;
import com.java.util.CollectionUtils;
import com.myabtis.generate.result.TableColumResult;



@Intercepts({
    @Signature(type = ResultSetHandler.class, method = "handleCursorResultSets", args = {Statement.class}),
    @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
    })
public class ResultSetInterceptor implements Interceptor{

    private static Logger log = LoggerFactory.getLogger(ResultSetInterceptor.class);
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
       
        
         if(invocation.getTarget() instanceof DefaultResultSetHandler){
             List<TableColumResult> results = CaseUtils.caseTo(invocation.proceed());
             MetaObject  resultSetHandlerMeta =SystemMetaObject.forObject(invocation.getTarget());
             MappedStatement mappedStatement = CaseUtils.caseTo(resultSetHandlerMeta.getValue("mappedStatement"));
             if(CollectionUtils.isNotEmpty(mappedStatement.getResultMaps())){
                 ResultMap rest =  mappedStatement.getResultMaps().get(0);
                 if(rest.getType().isAssignableFrom(TableColumResult.class)){
                 Transaction transaction = CaseUtils.caseTo(resultSetHandlerMeta.getValue("executor.transaction"));
                 BoundSql boundSql = CaseUtils.caseTo(resultSetHandlerMeta.getValue("boundSql"));
                 ParamMap<?> paramMap =  CaseUtils.caseTo(boundSql.getParameterObject());
                 Connection conn = transaction.getConnection();
                 Statement st = conn.createStatement();
                 st.execute("select * from "+paramMap.get("tableName"));
                 final ResultSetMetaData metaData = st.getResultSet().getMetaData();
                 final int columnCount = metaData.getColumnCount();
                 results.stream().forEach(r->{
                     for (int i = 1; i <= columnCount; i++) {
                         try {
                            if(r.getColumnName().equalsIgnoreCase(metaData.getColumnName(i))){
                                 r.setColumnClassName(metaData.getColumnClassName(i));
                                 r.setColumnType(metaData.getColumnType(i));
                                 break;
                             }
                        } catch (Exception e) {
                            log.error("", e);
                        }
                         
                     }
                     log.info(r.toString());
                 });
                 
                 }
                 return results;
             }
             
             
             
         }
         
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof ResultSetHandler){
            //使用动态代理  对象调用intercept 方法
            return Plugin.wrap(target, this);
        }
        
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
    }
    
    
    //类型   MysqlDefs
   
   

}
