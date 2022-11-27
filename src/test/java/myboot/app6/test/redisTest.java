package myboot.app6.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import myboot.app6.dao.StudentRepository;
import myboot.app6.model.Student;

@SpringBootTest
public class redisTest {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void saveStudentById() {
		Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		
		studentRepository.save(student);
		
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		assertEquals(retrievedStudent.getName(), "John Doe");
	}
	

	@Test
	public void testGetById() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		assertEquals(retrievedStudent.getName(), "John Doe");
	}
	
	@Test
	public void testUpdateById() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		retrievedStudent.setName("Richard Watson");
		studentRepository.save(retrievedStudent);
		assertEquals(retrievedStudent.getName(), "Richard Watson");
	}
	

	/*@Test
	public void testDeleteById() {
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();		
		studentRepository.deleteById(retrievedStudent.getId());
		
		Student retrievedStudent2 = studentRepository.findById("Eng2015001").get();
		assertEquals(retrievedStudent2.getName(), null);
	}*/
	
}
