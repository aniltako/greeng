package com.invitech.hibernate.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.invitech.core.entity.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.userName LIKE :userName OR u.email LIKE :email")
	List<User> findByAccountNameOrEmail(@Param("userName") String userName, @Param("email") String email);
	
	@Query("SELECT u FROM User u")
	List<User> findAllUser();
	
	@Query("SELECT u FROM User u WHERE u.userName LIKE :userName")
	User findUserByUserName(@Param("userName") String userName);
	
}
