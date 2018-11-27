package com.invitech.hibernate.dto;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invitech.core.entity.QUser;
import com.invitech.core.entity.User;
import com.mysema.query.jpa.impl.JPAQuery;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
    EntityManager entityManager;
	
	@Override
	public void updateUser(User user) {
				
	}

	@Override
	public User getUserById(Long userId) {
		final QUser u = QUser.user;
		JPAQuery query = new JPAQuery(entityManager);
				
		List<User> user = query.from(u).where(u.userId.eq(userId)).list(u);
		if(user != null){
			return user.get(0);
		}
		return null;
	}

}
