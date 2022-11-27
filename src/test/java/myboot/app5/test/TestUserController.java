package myboot.app5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import myboot.app1.model.Movie;
import myboot.app5.web.XUserDTO;

public class TestUserController {
	
	public String token;
	
	@Test
	public void testLogin() {
		RestTemplate restTemplate = new RestTemplate();
		String API = "http://localhost:8081/secu-users/";
		String url = API + "login?username=aaa&password=aaa";
		ResponseEntity<String> response = restTemplate.postForEntity(url,null,String.class);
		this.token = response.getBody();
		


		String url2 = "http://localhost:8081/secu-users/me";
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + this.token);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<XUserDTO> response2 = restTemplate.exchange(url2, HttpMethod.GET, requestEntity, XUserDTO.class);
		
		assertEquals(response2.getStatusCode(), HttpStatus.OK);
		assertEquals("aaa", response2.getBody().getUsername());
	}
	
	
	
}
