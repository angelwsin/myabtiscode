package com.java.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.myabtis.generate.request.MapperRequest;

public class GenBeanFactory {
    
    public    static Properties prop = new Properties();
    private final static String DEFAULT = "src/main/java/";
   
    public static String get(String key){
        return prop.getProperty(key);
    }
    
    static{
        Properties prop = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/default.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            //logger.error("", e);
        }
        
        Velocity.init(prop);
    }
    
    public static void genBean(MapperRequest meta){
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/bean.vm");
        //
       File file =   new File(meta.getDestPath()+DEFAULT+meta.getBeanImportPackage().replace(".", "/"));
       System.out.println(file.getAbsolutePath());
       if(!file.exists()){
           file.mkdir();
       }
       OutputStream out = null;
    try {
        File beanFile =  new File(file.getAbsolutePath()+File.separator+meta.getBeanName()+".java");
        if(!beanFile.exists()){
            beanFile.createNewFile();
        }
        out = new FileOutputStream(beanFile);
        Writer w =  new OutputStreamWriter(out);
        VelocityContext  context = new VelocityContext();
        context.put("classMeta", meta);
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
       // logger.error("", e);
    }
      
    }
    
    public static void genSqlMap(MapperRequest meta,VelocityContext  context){
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/sqlMap.vm");
        //
       File file =   new File(meta.getDestPath()+meta.getSqlMapPath());
       System.out.println(file.getAbsolutePath());
       if(!file.exists()){
           file.mkdir();
       }
       OutputStream out = null;
    try {
        File beanFile =  new File(file.getAbsolutePath()+File.separator+meta.getBeanName()+"-sqlMap.xml");
        if(!beanFile.exists()){
            beanFile.createNewFile();
        }
        out = new FileOutputStream(beanFile);
        Writer w =  new OutputStreamWriter(out);
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
       // logger.error("", e);
    }
      
    }
    
    public static void genMapper(MapperRequest meta){
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/mapper.vm");
        //
       File file =   new File(meta.getDestPath()+DEFAULT+meta.getMapperImportPackage().replace(".", "/"));
       System.out.println(file.getAbsolutePath());
       if(!file.exists()){
           file.mkdir();
       }
       OutputStream out = null;
    try {
        File beanFile =  new File(file.getAbsolutePath()+File.separator+meta.getDaoName()+".java");
        if(!beanFile.exists()){
            beanFile.createNewFile();
        }
        out = new FileOutputStream(beanFile);
        VelocityContext  context = new VelocityContext();
        context.put("sqlMeta", meta);
        Writer w =  new OutputStreamWriter(out);
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
       // logger.error("", e);
    }
      
    }

}
