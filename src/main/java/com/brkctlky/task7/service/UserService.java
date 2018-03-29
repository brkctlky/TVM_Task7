package com.brkctlky.task7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brkctlky.task7.entity.User;
import com.brkctlky.task7.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
			return userRepository.findOne(id);
	}

	public void save(User user) {
		userRepository.save(user);	
	}

	public void remove(User user) {
		userRepository.delete(user.getId());
	}

	public Integer update(User user) {
		Integer tmp = user.getId();
		userRepository.delete(user);
		return tmp;
	}	
	
}
