package com.invitech.service.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.FileFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invitech.core.entity.User;
import com.invitech.errors.http.InvitechBusinessException;
import com.invitech.hibernate.dto.UserDAO;
import com.invitech.hibernate.repository.UserRepository;

@Service
public class UserResourceServiceImpl implements UserResourceService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<UserResource> getAllUser() {
		List<UserResource> userResourceList = convertToUserResource(userRepository.findAllUser());
		return userResourceList;
	}

	@Override
	@Transactional
	public void saveUser(UserResource userResource) {
		User u = getUserByUserName(userResource.getUserName());
		if(u == null){			
			User user = new User();
			user.setUserName(userResource.getUserName());
			user.setFirstName(userResource.getFirstName());
			user.setLastName(userResource.getLastName());
			user.setEmail(userResource.getEmail());
			userRepository.save(user);
		}else{
			throw new InvitechBusinessException("User name already exits");
		}
		
	}

	@Override
	public void updateUser(UserResource user) {
		User u = userDAO.getUserById(user.getUserId());
		if(u != null){			
			u.setUserName(user.getUserName());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			userRepository.save(u);
		}else{
			throw new InvitechBusinessException("User already exits.");
		}
	}

	@Override
	public User getUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}
	
	private List<UserResource> convertToUserResource(List<User> userList){
		List<UserResource> userResources = new ArrayList<UserResource>();
		for (User user : userList) {
			UserResource ur = new UserResource();
			ur.setUserId(user.getUserId());
			ur.setUserName(user.getUserName());
			ur.setFirstName(user.getFirstName());
			ur.setLastName(user.getLastName());
			ur.setEmail(user.getEmail());
			
			userResources.add(ur);
		}
		return userResources;
	}

}
