package com.brkctlky.task7.service;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brkctlky.task7.entity.*;
import com.brkctlky.task7.repository.*;

@Transactional
@Service
public class InitDbService {;
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setFirstName("Mehmet Burak");
		userAdmin.setLastName("Çatalkaya");
		userAdmin.setAddress("Ensar cd. Gençosman mh. Güngören Ýstanbul Türkiye");
		userAdmin.setEmail("mehmetbrk26@gmail.com");
		userRepository.save(userAdmin);

		User user1 = new User();
		user1.setName("user1");
		user1.setFirstName("user1 FName");
		user1.setLastName("user1 LName");
		user1.setAddress("user1 Address");
		user1.setEmail("user1@mail.com");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setName("user2");
		user2.setFirstName("user2 FName");
		user2.setLastName("user2 LName");
		user2.setAddress("user2 Address");
		user2.setEmail("user2@mail.com");
		userRepository.save(user2);
		
		User user3 = new User();
		user3.setName("user3");
		user3.setFirstName("user3 FName");
		user3.setLastName("user3 LName");
		user3.setAddress("user3 Address");
		user3.setEmail("user3@mail.com");
		userRepository.save(user3);
		
		User user4 = new User();
		user4.setName("user4");
		user4.setFirstName("user4 FName");
		user4.setLastName("user4 LName");
		user4.setAddress("user4 Address");
		user4.setEmail("user4@mail.com");
		userRepository.save(user4);
		
	}
	
}
