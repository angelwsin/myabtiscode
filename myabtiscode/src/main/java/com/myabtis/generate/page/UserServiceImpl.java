package com.myabtis.generate.page;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.java.bean.User;
import com.java.mapper.UserMapper;

public class UserServiceImpl  implements UserService<User>{

	private  UserMapper  userMapper;
	
	

	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}



	
	
	
	public static void main(String[] args) {
		//配置文件解析
        InputStream is =    Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/myBatis_conf.xml");
        //build 模式  创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =    new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession(false);
         UserMapper  userMapper =     session.getMapper(UserMapper.class);
         UserService<User> userservice = new UserServiceImpl(userMapper);
         User u = new User();
         u.setName("zha");
         Paging<User> pg = userservice.paging(u, 1, 4);
         System.out.println(pg.getTotalPage());
         session.commit();
	}






	@Override
	public List<User> getByCondition(User condition, int offset, int rows) {
		// TODO Auto-generated method stub
		return userMapper.getUser(condition, offset, rows);
	}






	@Override
	public long getByConditonCount(User condition) {
		// TODO Auto-generated method stub
		return userMapper.getUserCount(condition);
	}

}
