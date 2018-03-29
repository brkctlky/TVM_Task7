package com.brkctlky.task7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brkctlky.task7.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
