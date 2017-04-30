package com.java.mapper;

import   java.util.List;
import   org.apache.ibatis.annotations.Param;
import   com.java.bean.Users;



public interface UsersMapper {

  
         public   int deleteUsersById( int id );
         public   int insertUsers( Users users );
         public   long getUsersCount( Users users );
         public   List<Users> getUsers( @Param("users")Users users,@Param("offset")Integer offset,@Param("rows")Integer rows );
         public   Users getUsersById( int id );
         public   int updateUsers( Users users );
    
}