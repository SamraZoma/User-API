package com.api.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo.model.User;
import com.api.demo.repository.UserRepository;
import com.api.demo.util.JwtTokenUtil;
import com.api.demo.util.Util;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public User getUserByIdAndAccessToken(String id, String accessToken) {
		// Validate the accessToken (You need to implement this method in JwtTokenUtil)
		boolean isValidToken = jwtTokenUtil.validateToken(accessToken);

		if (isValidToken) {
			Optional<User> optionalUser = repo.findById(id);
			return optionalUser.filter(user -> marketingConsentCheck(user)).orElse(null);
		}

		return null;
	}

	private boolean marketingConsentCheck(User user) {
		// Omit email property if marketingConsent is false
		if (!user.isMarketingConsent()) {
			user.setEmail(null);
		}
		return true;
	}

	public String save(User user) {
		String id = Util.encryptID(user.getEmail());
		user.setId(id);

		;
		if (getUser(id) != null) {
			return "this email already exiet ";
		} else {
			this.repo.save(user);
		}
		return "{\r\n \"id\": " + user.getId() + "\n \"accessToken\": " + JwtTokenUtil.generateToken() + "\n}";
	}

	public User getUser(String id) {

		return repo.findById(id).orElse(null);
	}

	/*
	 * public User deleteUser(String id) { Optional<User> user =
	 * this.repo.findById(id); this.repo.deleteById(id); return user.orElse(null); }
	 */

}
