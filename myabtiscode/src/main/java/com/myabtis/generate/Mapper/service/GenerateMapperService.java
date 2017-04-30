package com.myabtis.generate.Mapper.service;

import com.myabtis.generate.request.MapperRequest;
import com.myabtis.generate.request.MapperRequestBuilder;

public interface GenerateMapperService {
    
    
    public void  generateMapper(MapperRequest request) throws Exception;
    
    public void generateMapper(MapperRequestBuilder request) throws Exception;
   
}
