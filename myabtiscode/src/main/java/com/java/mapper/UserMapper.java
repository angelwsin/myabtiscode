package com.java.mapper;

import   java.util.List;
import   org.apache.ibatis.annotations.Param;
import   com.java.bean.User;



public interface UserMapper {

  
         public   int insertUser( User user );
         public   User getUserById( int id );
         public   long getUserCount( User user );
         public   List<User> getUser( @Param("user")User user,@Param("offset")Integer offset,@Param("rows")Integer rows );
         public   int updateUser( User user );
         public   int deleteUserById( int id );
    
}