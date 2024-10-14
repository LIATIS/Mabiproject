package com.searchpj.demo.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.searchpj.demo.user.dto.UserDTO;

public interface UserRepository extends MongoRepository<UserDTO, String> {
	
    @Query("{id:'?0'}")
    UserDTO findByUserId(String userId);
    
}
