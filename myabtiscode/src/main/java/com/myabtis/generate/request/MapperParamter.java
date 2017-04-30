package com.myabtis.generate.request;

import java.util.ArrayList;
import java.util.List;

public class MapperParamter  {

    /**  */
    private static final long serialVersionUID = 1L;
  
    private List<Param>     params = new ArrayList<>();
    
    public String paras(){
        StringBuilder str  = new StringBuilder();
        int count = 0;
        boolean  param = params.size()>1;
       for(Param p :params){
           count++;
          if(param)str.append("@Param(\"").append(p.getArgName()).append("\")");
          str.append(p.getArgType()).append(' ').append(p.getArgName());
          if(count<params.size())str.append(',');
       }
       return str.toString();
    }
    
    
    public void put(String paramClass,String argsName){
    	params.add(new Param(paramClass,argsName));
    }
    
    
    static class Param {
	      private String  argType;
	      private String  argName;

		public Param(String argType, String argName) {
			this.argType = argType;
			this.argName = argName;
		}

		public String getArgType() {
			return argType;
		}

		public void setArgType(String argType) {
			this.argType = argType;
		}

		public String getArgName() {
			return argName;
		}

		public void setArgName(String argName) {
			this.argName = argName;
		}
		
		
	      
   }
     
     

}
