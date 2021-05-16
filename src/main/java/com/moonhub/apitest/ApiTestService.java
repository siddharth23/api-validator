package com.moonhub.apitest;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ApiTestService {
    private final ApiRequestor requester = new ApiRequestor();
    public String getAPITestResponse(APIValidatorForm apiValidatorForm) throws ParseException {
       switch (apiValidatorForm.getMethod()){
           case "get":  requester.makeGetCall(apiValidatorForm.getUrl());break;
           case "post":  requester.makePostCall(apiValidatorForm.getUrl(),apiValidatorForm.getRequestBody());break;
           default : return "inputError";
       }
       return "results";
    }
}
