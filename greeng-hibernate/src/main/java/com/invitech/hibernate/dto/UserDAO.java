package com.invitech.hibernate.dto;

import com.invitech.core.entity.User;

public interface UserDAO {
	void updateUser(User user);
	User getUserById(Long userId);
}
