package com.searchpj.demo.elasticController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.searchpj.demo.elasticService.ElasticService;

@Controller
public class ElasticController {
	private static final Logger logger = LoggerFactory.getLogger(ElasticController.class);
	
	@Autowired
	private ElasticService elasticService;

    @GetMapping("/greet")
    @ResponseBody
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
    	
    	return "dd";
    }

    //오류남
    @GetMapping("/index")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Welcome to Spring Boot!");
        return mav;
    }
}