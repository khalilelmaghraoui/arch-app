package myboot.manager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myboot.app1.model.Movie;
import myboot.manager.model.Person;





@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Integer> {
	@Query(value = "SELECT * FROM Person p WHERE p.firstname = ?1", nativeQuery = true)
	List<Person> findByFirstName(String name);
}