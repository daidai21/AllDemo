package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Map;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

	/**
	 * database
	 */
	private static final Map<Long, User> DATABASE = Maps.newConcurrentMap();

	/**
	 * init data
	 */
	static {
		DATABASE.put(1L, new User(1L, "user1"));
		DATABASE.put(2L, new User(1L, "user2"));
		DATABASE.put(3L, new User(1L, "user3"));
	}

	/**
	 * save or update
	 *
	 * @param user
	 * @return User
	 */
	@CachePut(value = "user", key = "#user.id")
	@Override
	public User saveOrUpdate(User user) {
		DATABASE.put(user.getId(), user);
		log.info("save user  user = {}", user);
		return user;
	}

	/**
	 * get
	 *
	 * @param id
	 * @return User
	 */
	@Cacheable(value = "user", key = "#id")
	@Override
	public User get(Long id) {
		log.info("get user  id = {}", id);
		return DATABASE.get(id);
	}

	/**
	 * delete
	 *
	 * @param id
	 * @return
	 */
	@CacheEvict(value = "user", key = "#id")
	@Override
	public void delete(Long id) {
		DATABASE.remove(id);
		log.info("del user  id = {}", id);
	}
}