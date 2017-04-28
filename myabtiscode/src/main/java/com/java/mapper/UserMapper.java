package com.java.mapper;

import   java.util.List;
import   com.java.bean.User;



public interface UserMapper {

  
         public   List<User> getUsers( User user );
         public   int insertUser( User user );
         public   int updateUser( User user );
         public   User getUserById( int id );
    
}