package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.WrongPasswordException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public User signUp(User user) throws UserAlreadyExistException{
		// TODO Auto-generated method stub
		User user1=userRepository.findByUserName(user.getUserName());
		if (user1!=null) {
			throw new UserAlreadyExistException("User Already Exists");
		}
		else {
			userRepository.save(user);
			return user;
		}
		
	}
	@Override
	public User signIn(User user) throws WrongPasswordException {
		User user1=userRepository.findByUserName(user.getUserName());
		if(user.getPassword().equals(user1.getPassword()))
		{
			return user1;
		}
		else
		{
			throw new WrongPasswordException ("Invaild login details");
		}
		
	}
}
