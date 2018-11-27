package com.invitech.service.resource;

import java.util.List;

import com.invitech.core.entity.User;

public interface UserResourceService {
	List<UserResource> getAllUser();
	void saveUser(UserResource user);
	void updateUser(UserResource user);
	User getUserByUserName(String userName);
}
