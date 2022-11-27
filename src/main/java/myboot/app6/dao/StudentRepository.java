package myboot.app6.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myboot.app6.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}