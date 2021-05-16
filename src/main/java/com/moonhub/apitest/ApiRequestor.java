package com.moonhub.apitest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class ApiRequestor {
    private static final Logger log = LoggerFactory.getLogger(ApiRequestor.class);
    public void makeGetCall(String url ) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject( url, String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);
        log.info("==== RESTful API Response using Spring REST Template START =======" + url);
        log.info("==== RESTful API Response using Spring RESTTemplate END =======");
        log.info(json.keySet().toString());

    }

    public void makePostCall(String url, String requestBody) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject( url, String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);
        log.info("==== RESTful API Response using Spring REST Template START =======" + url);
        log.info("==== RESTful API Response using Spring RESTTemplate END =======");
        log.info(json.keySet().toString());
    }
}
