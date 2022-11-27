package myboot.app1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myboot.app1.model.Movie;

@Repository
@Transactional
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	List<Movie> findByName(String name);

	List<Movie> findByNameLike(String name);
	
	@Query(value = "SELECT * FROM Movie m WHERE m.year < ?1", nativeQuery = true)
	List<Movie> findAllBefore(int year);
	
	@Query(value = "SELECT * FROM Movie m WHERE m.name = :name and m.year = :year", nativeQuery = true)
	List<Movie>  findByNameAndYear(@Param("name") String name,@Param("year")  int year);


}