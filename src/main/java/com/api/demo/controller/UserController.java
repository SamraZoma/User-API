package com.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.model.User;
import com.api.demo.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/{id}")
	public User getUserByIdAndAccessToken(@PathVariable String id, @RequestParam String accessToken) {
		return service.getUserByIdAndAccessToken(id, accessToken);
	}

	@PostMapping("/")
	public String sava(@RequestBody User user) {
		return service.save(user);
	}

	/*
	 * // http://localhost:9082/v1/user?1
	 * 
	 * @GetMapping("/user") public User getUser(@RequestParam String id) { String y
	 * = service.getUser(id).getFirstName(); System.out.println("\n>>>>>>>>>>>> " +
	 * y);
	 * 
	 * return service.getUser(id);
	 * 
	 * }
	 * 
	 * // http://localhost:9082/v1/test
	 * 
	 * @GetMapping("/test") public String test() { return "HI SAMRA test"; }
	 * 
	 * // http://localhost:9082/v1/delete?id=4
	 * 
	 * @GetMapping("/delete") public User delete(@RequestParam String id) { User
	 * user = service.getUser(id); service.deleteUser(id).getId();
	 * System.out.println("\n>>>>>>>>>>>> " + user.getFirstName()); return user;
	 * 
	 * }
	 */

}
