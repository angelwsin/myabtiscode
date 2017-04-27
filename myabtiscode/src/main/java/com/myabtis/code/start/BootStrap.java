package com.myabtis.code.start;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BootStrap {
    
    
    public static void main(String[] args) throws Exception{
        //配置文件解析
        InputStream is =    Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/myBatis_conf.xml");
        //build 模式  创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =    new SqlSessionFactoryBuilder().build(is);
        //配置文件的解析 委托给 XMLConfigBuilder 解析模式 XPathParser
        //配置文件中的组件
        //1.顶级组件标签 configuration  解析成Configuration
        //2.设置组件标签 settings       解析成 Properties  设置到 顶级组件中
        //3.属性组件标签  properties 可以是 name=value 或 resource 或 url 解析成 顶级组件的 variables属性
        //4.别名组件typeAliases 简化包名  可以是 包名 或 类    解析成   顶级组件的 typeAliasRegistry 属性
        //5.插件组件plugins     类似于aop 底层实现  java动态代理  解析成 顶级组件 interceptorChain 属性
        //6.创建Mapper接口的实现类的工厂 objectFactory  解析成  顶级组件 objectFactory 属性
        //7.objectWrapperFactory                解析成 顶级组件 objectWrapperFactory 属性
        //8.reflectorFactory                    解析成 顶级组件 reflectorFactory     属性
        //9.Environment 环境 中 包括 transactionManager(事务管理器),dataSource 数据库信息  解析成 顶级组件的 environment 属性
        //10.databaseIdProvider  数据库提供商 解析成 顶级组件 databaseId 属性 如 MySql
        //11.typeHandlers   处理关系映射handler  javaType jdbcType 映射的handler
        //12.mappers  sqlMap的组件          解析成  顶级组件的mapperRegistry属性
        // 对 mappers的解析过程
        /**
         * 1)package 的解析   注解
         *   读取package 下面的类  判断是不是 Object.class 的子类
         *   类加载器加载类  加载成功放在 mapperRegistry的knownMappers属性Map中
         *   knownMappers.put(type, new MapperProxyFactory<T>(type))
         *   value 为 接口代理类的实例化工厂（动态代理）
         *   MapperAnnotationBuilder.parse() 进行解析
         *    >对 sqlMap.xml文件解析 （非必须的）
         *    >注解的方法的解析  MapperAnnotationBuilder.parseStatement(Method)
         *     参数的处理  MapperAnnotationBuilder.getParameterType(Method)
         *     得到 LanguageDriver  用于创建 SqlSource
         *     解析statement  MapperAnnotationBuilder.getSqlSourceFromAnnotations(Method, Class<?>, LanguageDriver) 
         *     分两组注解 创建  SqlSource  XMLLanguageDriver.createSqlSource(Configuration, String, Class<?>)
         *      1)Select,Insert,Update,Delete   基础的sql语句的书写
         *        引入： MyAbtis 中 $和#的区别   ${} 中的直接替换
         *        根据是否有 ${}判断是否 动态
         *        TextSqlNode textSqlNode = new TextSqlNode(script)
         *        动态 DynamicSqlSource
         *        否则 RawSqlSource --StaticSqlSource
         *      2)SelectProvider,InsertProvider,UpdateProvider,DeleteProvider 可以在方法内书写 sql语句返回值 是String
         *         这里实例的是SqlSource的子类ProviderSqlSource
         *    
         *    SqlSourceBuilder.parse(String, Class<?>, Map<String, Object>) 处理#
         *    
         *    ParameterMappingTokenHandler handler = new ParameterMappingTokenHandler(configuration, parameterType, additionalParameters);
              GenericTokenParser parser = new GenericTokenParser("#{", "}", handler);
              String sql = parser.parse(originalSql);
              
         *    解析参数 ParameterMappingTokenHandler 组装在 ParameterMapping
         *    GenericTokenParser 解析sql
         *    所有信息存放在SqlSource中
         *    所有 解析的信息组装成MappedStatement 存放在顶级组件的mappedStatements中 key=mappedStatementId (namespace.id)
         *    最终的得到 BoundSql
         *    2)sqlMap.xml解析
         *    XMLMapperBuilder.configurationElement(XNode)
         *    XMLStatementBuilder.parseStatementNode()
         *    
         *    
         *    
         *    ------------------
         *    Mapper的生成及sql的调用
         *    1）从 mapperRegistry的knownMappers 中根据类型取出 对象生成工厂
         *       使用动态代理 生成代理对象 MapperProxy
         *     在MapperMethod.execute(SqlSession, Object[]) 中完成方法的代理调用
         *     根据 mappedStatementId 从mappedStatements.get(id)中得到MappedStatement
         *     根据不同的执行策略Executor来执行 (如BatchExecutor,CachingExecutor等)ExecutorType
         *     Configuration.newExecutor(Transaction, ExecutorType)
         *     在创建执行器时 可以使用 plugins 对StatementHandler进行 aop
         *     创建StatementHandler处理statement的处理
         *     Configuration.newStatementHandler(Executor, MappedStatement, Object, RowBounds, ResultHandler, BoundSql)
         *     根据RoutingStatementHandler 创建不同的StatementHandler
         *     StatementHandler种类 三种 sql Statement
         *     STATEMENT, PREPARED, CALLABLE
         *     此处可以使用 plugins 对StatementHandler进行 aop
         *     根据Transaction 事务管理器得到数据库的Connection
         *     PreparedStatement参数的填充
         *     PreparedStatementHandler.parameterize(Statement)
         */      
        //根据不同的参数 sqlSessionFactory 创建不同的session
        SqlSession session = sqlSessionFactory.openSession(false);
       
    }

}
