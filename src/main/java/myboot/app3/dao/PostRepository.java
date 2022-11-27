package myboot.app3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myboot.app3.model.Post;


@Repository
@Transactional
public interface PostRepository extends CrudRepository<Post, Integer> {



}