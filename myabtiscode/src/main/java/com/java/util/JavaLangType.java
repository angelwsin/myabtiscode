package com.java.util;

import java.util.HashMap;
import java.util.Map;

public class JavaLangType {
    private final  Map<String,String> TYPE_ALIASES = new HashMap<String,String>(21);
    public JavaLangType(){
    registerAlias(String.class.getName(),"String");

    registerAlias( Byte.class.getName(),"Byte");
    registerAlias( Long.class.getName(),"Long");
    registerAlias( Short.class.getName(),"Short");
    registerAlias(Integer.class.getName(),"Integer");
    registerAlias( Double.class.getName(),"Double");
    registerAlias( Float.class.getName(),"Float");
    registerAlias( Boolean.class.getName(),"Boolean");
    registerAlias( Void.class.getName(),"Void");
  /*  registerAlias("byte[]", Byte[].class);
    registerAlias("long[]", Long[].class);
    registerAlias("short[]", Short[].class);
    registerAlias("int[]", Integer[].class);
    registerAlias("integer[]", Integer[].class);
    registerAlias("double[]", Double[].class);
    registerAlias("float[]", Float[].class);
    registerAlias("boolean[]", Boolean[].class);*/

    registerAlias(byte.class.getName(),"byte");
    registerAlias(long.class.getName(),"long");
    registerAlias(short.class.getName(),"short");
    registerAlias(int.class.getName(),"int");
    registerAlias(double.class.getName(),"double");
    registerAlias(float.class.getName(),"float");
    registerAlias(boolean.class.getName(),"boolean");
    registerAlias(void.class.getName(),"void");
 /*   registerAlias("_byte[]", byte[].class);
    registerAlias("_long[]", long[].class);
    registerAlias("_short[]", short[].class);
    registerAlias("_int[]", int[].class);
    registerAlias("_integer[]", int[].class);
    registerAlias("_double[]", double[].class);
    registerAlias("_float[]", float[].class);
    registerAlias("_boolean[]", boolean[].class);

    registerAlias("date", Date.class);
    registerAlias("decimal", BigDecimal.class);
    registerAlias("bigdecimal", BigDecimal.class);
    registerAlias("biginteger", BigInteger.class);
    registerAlias("object", Object.class);

    registerAlias("date[]", Date[].class);
    registerAlias("decimal[]", BigDecimal[].class);
    registerAlias("bigdecimal[]", BigDecimal[].class);
    registerAlias("biginteger[]", BigInteger[].class);
    registerAlias("object[]", Object[].class);

    registerAlias("map", Map.class);
    registerAlias("hashmap", HashMap.class);
    registerAlias("list", List.class);
    registerAlias("arraylist", ArrayList.class);
    registerAlias("collection", Collection.class);
    registerAlias("iterator", Iterator.class);

    registerAlias("ResultSet", ResultSet.class);*/
    }
    
    public static void main(String[] args) {
        JavaLangType j = new JavaLangType();
         System.out.println(byte.class.getName());
    }
   

    public boolean isExist(String value){
        return TYPE_ALIASES.containsKey(value);
    }
  
    public String getAlias(String key){
         return TYPE_ALIASES.get(key);
    }
    
    public   void registerAlias(String key,String value) {
        TYPE_ALIASES.put(key,value);
      }
    


}
