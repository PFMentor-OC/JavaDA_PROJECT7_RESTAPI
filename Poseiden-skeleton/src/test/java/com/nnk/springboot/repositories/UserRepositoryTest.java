package com.nnk.springboot.repositories;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.User;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	void bidListTest() {

		User user = new User("username", "Azerty@1", "fullname");
		// Save
		userRepository.save(user);
		assertNotNull(user.getId());
		assertTrue(user.getUsername().equals("username"));
		;

		// Update
		Integer id = user.getId();
		userRepository.findById(id);
		user.setUsername("UserName Update");
		// userRepository.updateUser(id, user);
		assertTrue(user.getUsername().equals("UserName Update"));

		// Find
		List<User> listResult = userRepository.findAll();
		assertTrue(listResult.size() > 0);
         //Delete
//		Integer id2 = user.getId();
//		userRepository.delete(user);
//		Optional<User> userList = userRepository.findById(id2);
//		assertFalse(userList.isPresent());
	}

}
