package myboot.app3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import myboot.app1.model.Movie;
import myboot.app3.model.User;

@SpringBootTest
public class TestUserRestController {
	
	@Test
	public void testPostUser(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/api/users";
		User u = new User();
		u.setEmail("test2");
		u.setName("mario");
		u.setId((long) 1);
		ResponseEntity<User> response = restTemplate.postForEntity(url, u ,User.class);
		assertEquals(response.getBody().getName(), "mario");
	}
	
	

	@Test
	public void testGetUserById(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/api/users/1";
		ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
		assertEquals(response.getBody(), "mario");
	}
}
