package myboot.app3.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myboot.app1.dao.MovieRepository;
import myboot.app3.dao.UserRepository;
import myboot.app3.model.User;

@RestController
@RequestMapping("/api")
public class UserRestController {
	@Autowired
    UserRepository repo;

	
	/*@PostMapping("/users")
	public User postMovie(@RequestBody User u) {
		System.out.println(u.getName());
	    repo.save(u);
	    return u;
	}
	
	
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return repo.findById(id);
    }*/
}
