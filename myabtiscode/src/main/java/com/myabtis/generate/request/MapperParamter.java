package com.myabtis.generate.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapperParamter  extends HashMap<String, String>{

    /**  */
    private static final long serialVersionUID = 1L;
    
    
    
    
    public String paras(){
        StringBuilder str  = new StringBuilder();
        int count = 0;
       for(Map.Entry<String, String> entry: this.entrySet()){
           count++;
          str.append(entry.getKey()).append(' ').append(entry.getValue());
          if(count<this.size())str.append(',');
       }
       return str.toString();
    }
    
    
    
   
     
     

}
