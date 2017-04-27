package com.java.sql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

//对事务管理器的封装
public class TxManager {
    
    
    private DataSource dataSource;
    
    private Connection connection;
    
    

    public TxManager(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    public Connection getConnection(boolean autoCommit) throws SQLException{
        connection =   dataSource.getConnection();
        connection.setAutoCommit(autoCommit);
        return connection;
    }  
    
    
    public void commit() throws SQLException{
        if(connection!=null&&!connection.getAutoCommit()){
            connection.commit();
        }
    }
    
   public void rollback() throws SQLException{
        if(connection!=null&&!connection.getAutoCommit()){
            connection.rollback();
        }
        
    }
   
   public void close() throws SQLException{
       if(connection!=null){
           connection.setAutoCommit(true);
           connection.close();
       }
   }
    

}
