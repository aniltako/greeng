package com.invitech.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invitech.service.resource.UserResource;
import com.invitech.service.resource.UserResourceService;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserResourceService userResourceService;

	@RequestMapping(value="/api/user", method = RequestMethod.GET)
	public List<UserResource> getUsers(){
		List<UserResource> userResource = userResourceService.getAllUser();
		return userResource;
	}
	
	@RequestMapping(value="/api/user", method = RequestMethod.POST)
	public void saveUser(@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email){
		
		UserResource ur = new UserResource();
		ur.setUserName(userName);
		ur.setFirstName(firstName);
		ur.setLastName(lastName);
		ur.setEmail(email);
		userResourceService.saveUser(ur);
		
	}
}
