package com.java.sql;

import java.sql.Connection;

public class DataBaseTest {
    
    
    public static void main(String[] args)throws Exception {
        DefDataSource source = new DefDataSource("com.mysql.jdbc.Driver", "root", "admin", "jdbc:mysql://localhost:3306/test");
        TxManager tx = new TxManager(source);
        Connection conn =   tx.getConnection(false);
        //普通
        conn.createStatement();
        //预处理 占位符
        conn.prepareStatement("");
        //调用存储过程
        conn.prepareCall("call ");
        
    }

}
