package myboot.app4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import myboot.app1.model.Movie;
import myboot.app1.model.Views;

public class TestMovieRestController {
	
	@Test
	public void testGetMovies() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/api/movies";
		ResponseEntity<Movie[]> response = restTemplate.getForEntity(url, Movie[].class);
		assertEquals(response.getBody()[0].getId(), 1);
	}
	
	@Test
	public void testgetByNameAndYear() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/api/movies?name=null&year=1983";
		ResponseEntity<Movie[]> response = restTemplate.getForEntity(url, Movie[].class);
		assertEquals(response.getBody()[0].getYear(), 1983);
	}
	@Test
	public void testGetMoviesID() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/api/movies/1";
		ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
		assertEquals(response.getBody().getId(), 1);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void whenUseJsonViewToSerialize_thenCorrect() 
	  throws JsonProcessingException {
	 
	    Movie movie = new Movie();
	    movie.setId(30);
	    movie.setDescription("test");
	    movie.setName("mario");

	    ObjectMapper mapper = new ObjectMapper();
	    mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

	    String result = mapper
	      .writerWithView(Views.Public.class)
	      .writeValueAsString(movie);

	    assertEquals(false, result.contains("mario"));
	    assertEquals(false, result.contains("test"));
	}
	
	@Test
	public void testDeleteMoviesID() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/api/movies/2";
		restTemplate.delete(url);
		ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}
