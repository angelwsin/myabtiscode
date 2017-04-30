package com.java.util;

public class StringUtils {
    
    
    public static String  getTableColField(String tableName){
            String[] s= tableName.split("_");
            if(s.length==1){
              return   tableName;
            }
           StringBuilder build = new StringBuilder(s[0]);
           for(int i=1;i<s.length;i++){
               build.append(firstCharToUp(s[i]));
           }
           return build.toString();
    }
    
    public static String firstCharToUp(String str){
           return str.substring(0, 1).toUpperCase()+str.substring(1);
    }
    
    public static String firstCharLowerCase(String str){
        return str.substring(0, 1).toLowerCase()+str.substring(1);
 }
    
    
    public static String getTableNameClass(String tableName){
        String[] s= tableName.split("_");
       StringBuilder build = new StringBuilder();
       for(int i=0;i<s.length;i++){
           build.append(firstCharToUp(s[i]));
       }
       return build.toString();
    }
    
    public static String getPram(String tableName){
        String[] s= tableName.split("_");
       StringBuilder build = new StringBuilder(s[0]);
       for(int i=1;i<s.length;i++){
           build.append(firstCharToUp(s[i]));
       }
       return build.toString();
    }
    
    public static boolean isEmpty(String str){
        return str==null || str.length()==0;
 }

   

}
