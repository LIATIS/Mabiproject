package com.searchpj.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.searchpj.demo.user.dto.UserDTO;
import com.searchpj.demo.user.repository.UserRepository;

@Service
public class JoinService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	//해당 id로 유저 조회
	public int findByUserId(String userId) {
		int result = 0;

		UserDTO data = userRepository.findByUserId(userId);
		if(data != null) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}

	
	//회원가입
	public int insertUser(UserDTO userDTO) {
		int result = 0;
		
		//가입직전 데이터 체크
		UserDTO data = userRepository.findByUserId(userDTO.getId());
		if(data != null) {	//데이터 있을경우 가입 불가
			result = -99;
		}else {

			userDTO.setRole("user");	//일반가입자 role
			userDTO.setPw( bCryptPasswordEncoder.encode(userDTO.getPw()) );	//암호화
			userRepository.save(userDTO);
			result = 0;
		}
		
		return result;
	}
	

}
