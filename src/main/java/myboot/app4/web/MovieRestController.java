package myboot.app4.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import myboot.app1.dao.MovieRepository;
import myboot.app1.model.Movie;

@RestController
@RequestMapping("/api")
public class MovieRestController {

    @Autowired
    MovieRepository repo;

  /*  @GetMapping("/movies")
    public Iterable<Movie> getMovies() {
        return repo.findAll();
    }*/

   
    @GetMapping("/movies/{id}")
    public Movie getMovieXithParam(@PathVariable int id) {
        return repo.findById(id).get();
    }
    
    @GetMapping("/movies")
    public List<Movie>  getMovieWithParam(@RequestParam(value="name") String name, @RequestParam(value="year")  int year) {
    	System.out.println(name);
    	System.out.println(year);
    	
    	
        return repo.findByNameAndYear(name, year);
    }
    
    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable int id) {
        repo.deleteById(id);
    }
    
    @PostMapping("/movies")
    public Movie postMovie(@RequestBody Movie m) {
        repo.save(m);
        return m;
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    class MovieNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }

}