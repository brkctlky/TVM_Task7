package com.brkctlky.task7.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brkctlky.task7.entity.User;
import com.brkctlky.task7.repository.UserRepository;
import com.brkctlky.task7.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	private User wantedUser;
	
	private Integer tmpId;
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
	
	@ModelAttribute("userDel")
	public User userNameToDel() {
		return new User();
	}
	
	@ModelAttribute("userFind")
	public User userNameToFind() {
		return new User();
	}
	
	@ModelAttribute("userUpdate")
	public User userNameToUpdate() {
		return new User();
	}
	
	@ModelAttribute("userUpdateForm2")
	public User userNameToUpdateForm2() {
		return new User();
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/addUser")
	public String showRegister() {
		return "user-register";
	}
	
	@RequestMapping("/delUser")
	public String showDeletion() {
		return "user-delete";
	}
	
	@RequestMapping("/findUser")
	public String showSearching(Model model) {
		model.addAttribute("user", wantedUser);
		return "user-search";
	}
	
	@RequestMapping("/updateUser")
	public String showUpdate(Model model) {
		model.addAttribute("user", wantedUser);
		return "user-update";
	}
	
	@RequestMapping("/updateUserInfos")
	public String showInfosToUpdate(Model model) {
		model.addAttribute("user", wantedUser);
		return "user-update-infos";
	}

	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/addUser.html?success=true";
	}
	
	@RequestMapping(value = "/delUser", method=RequestMethod.POST)
	public String doRemove(@ModelAttribute("userDel") User user) {
		List<User> users = userService.findAll();
		for (User aUser : users) {
		    if (aUser.getName().equals(user.getName())) {
		    	User userToDelete = userService.findOne(aUser.getId());
			    userService.remove(userToDelete);
			    return "redirect:/delUser.html?success=true";
		    } 
		}
		return "redirect:/delUser.html?success=false";
	}
	
	@RequestMapping(value = "/findUser", method=RequestMethod.POST)
	public String doSearch(@ModelAttribute("userFind") User user) {
		List<User> list = userService.findAll();
		wantedUser = new User();
		for (User aUser : list) {
		    if (aUser.getName().equals(user.getName())) {
			    wantedUser = aUser;
			    return "redirect:/findUser.html?success=true";
		    } 
		}
		return "redirect:/findUser.html?success=false";
	}
	
	@RequestMapping(value = "/updateUser", method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute("userUpdate") User user) {
		List<User> list = userService.findAll();
		wantedUser = new User();
		for (User aUser : list) {
		    if (aUser.getName().equals(user.getName())) {
			    wantedUser = aUser;
			    tmpId = userService.update(aUser);
			    return "redirect:/updateUserInfos.html?success=true";
		    } 
		}
		return "redirect:/updateUser.html?success=false";
	}
	
	@RequestMapping(value = "/updateUserInfos", method=RequestMethod.POST)
	public String doUpdateForm2(@ModelAttribute("userUpdateForm2") User user) {
		user.setId(tmpId);
		userService.save(user);
		return "redirect:/updateUser.html?successForm2=true";
	}
	
}
