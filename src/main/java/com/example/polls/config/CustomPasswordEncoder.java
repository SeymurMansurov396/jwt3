package com.example.polls.config;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder  {

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		 String hashed = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
	     return hashed;
	
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}

}
