package com.nnk.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnk.springboot.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   // @Query("SELECT u FROM USER u WHERE u.username=?1")
	public User findByUsername(String username);

}
