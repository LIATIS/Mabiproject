package com.searchpj.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.searchpj.demo.user.dto.UserDTO;
import com.searchpj.demo.user.service.JoinService;


@Controller
public class UserController {
	
	@Autowired
	private JoinService joinService;
	
	//회원가입 화면
    @GetMapping(value="/join")
    public String getJoin(Model model) {
        return "pages/join";
    }
    
    //회원가입 아이디 중복 체크
    @PostMapping(value="/checkUserDupli")
    @ResponseBody
    public ModelMap checkUserDupli(UserDTO userDTO) {
    	String userId = userDTO.getId();
    	int cnt =  joinService.findByUserId(userId);	// userId 조회
    	
    	ModelMap model = new ModelMap();
    	model.addAttribute("dataCnt", cnt);
    	return model;
    }

    
    //회원가입
    @PostMapping(value="/insertUser")
    @ResponseBody
    public ModelMap insertUser(UserDTO userDTO) {
    	int result = joinService.insertUser(userDTO);	// user insert

    	ModelMap model = new ModelMap();
       	model.addAttribute("resultCd", result);
    	return model;
    }
    
    //로그인 화면
    @GetMapping(value="/login")
    public String getLogin(Model model) {
        return "pages/login";
    }
    

    

}
