package com.moonhub.apitest;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Controller
    public class WebController implements WebMvcConfigurer {
        private static final Logger log = LoggerFactory.getLogger(WebController.class);

        @Autowired
        ApiTestService apiTestService;

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/test-api").setViewName("results");
        }

        @GetMapping("/")
        public String showForm(Model model) {
            model.addAttribute("apiValidatorForm", new APIValidatorForm());
            return "form";
        }

        @PostMapping("/")
        public String checkPersonInfo(@Valid APIValidatorForm apiValidatorForm, BindingResult bindingResult,Model model) throws ParseException {

            if (bindingResult.hasErrors()) {
//                model.addAttribute("errorValidator",bindingResult);
                for (ObjectError i : bindingResult.getAllErrors()){
                log.info(i.toString());
                    model.addAttribute("errorMessage","{\"error\":\""+i.getObjectName()+"\","+"\"message\":\""+i.toString()+"\"}");
                }
                return "inputError";
            }

            return apiTestService.getAPITestResponse(apiValidatorForm);

//            if(apiValidatorForm.getMethod().equals("get")){
//                verifyGetMethod(apiValidatorForm);
//            }
//            if(apiValidatorForm.getMethod().equals("post")){
//                verifyGetMethod(apiValidatorForm);
//            }

//            return "redirect:/test-api";
        }

    }
