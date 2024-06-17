package com.becoder.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.becoder.Repository.UserRepo;
import com.becoder.model.User;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public List<User> getAlluser() {
		
		return userRepo.findAll();
	}

	@Override
	public User getuserbyId(int id) {
		User user=userRepo.findById(id).get();		
		return user;
	}

	@Override
	public User saveUser(User user) {
		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("USER_Role");
		User newpass=userRepo.save(user);
		return newpass;
	}

}
