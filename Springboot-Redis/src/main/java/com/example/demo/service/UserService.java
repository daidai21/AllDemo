package com.example.demo.service;


import com.example.demo.entity.User;


public interface UserService {

	User saveOrUpdate(User user);

	User get(Long id);

	void delete(Long id);

}
