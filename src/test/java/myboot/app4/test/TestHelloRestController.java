package myboot.app4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestHelloRestController {
	
	@Test
	public void testHello() {
		RestTemplate restTemplate = new RestTemplate();
		String footURL = "http://localhost:8081/api/hello";
		ResponseEntity<String> response = restTemplate.getForEntity(footURL, String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testList() {
		RestTemplate restTemplate = new RestTemplate();
		String URL = "http://localhost:8081/api/list";
		ResponseEntity<Integer[]> response = restTemplate.getForEntity(URL, Integer[].class);
		assertEquals(Arrays.asList(response.getBody()), Arrays.asList(10, 20, 30));
		//ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		//assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testHelloWithMSG() {
		RestTemplate restTemplate = new RestTemplate();
		String URL = "http://localhost:8081/api/hello/mario";
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testHello2() {
		RestTemplate restTemplate = new RestTemplate();
		String URL = "http://localhost:8081/api/hello2";
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testNotFound() {
		RestTemplate restTemplate = new RestTemplate();
		String URL = "http://localhost:8081/api/notFound";
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void testExchange() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("myHeader", "myHeaderValue".toUpperCase());
	    
	    HttpEntity entity = new HttpEntity(headers);
	    RestTemplate restTemplate = new RestTemplate();
	    String URL = "http://localhost:8081/api/headers"; 
	    ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		assertEquals(response.getHeaders().get("resultHeader"), headers.get("myHeader"));
	}
	
	
}
	
