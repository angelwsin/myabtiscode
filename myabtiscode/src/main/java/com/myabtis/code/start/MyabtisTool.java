package com.myabtis.code.start;

import java.util.Arrays;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import com.myabtis.generate.result.TableColumResult;


//myabatis 反射类MetaObject
public class MyabtisTool {
    
    private static MyabtisTool tool = new MyabtisTool();
    
    public static MyabtisTool getInstance(){
        return tool;
    }
    
    protected ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
    protected ObjectFactory objectFactory = new DefaultObjectFactory();
    protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
    
    public static void main(String[] args) {
        TableColumResult rs  = new TableColumResult();
        MetaObject meta = tool.forObject(rs);
       String[] st =  meta.getSetterNames();
       Arrays.asList(st).forEach(s->System.out.println(s));
       //tool.forObject(object)
       SystemMetaObject.forObject(rs);
    }
    
    public MetaObject  forObject(Object object){
        return MetaObject.forObject(object, objectFactory, objectWrapperFactory, reflectorFactory);
    }
    
    
    
//JdbcType
}
