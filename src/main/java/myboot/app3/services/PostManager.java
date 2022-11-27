package myboot.app3.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import myboot.app3.model.Comment;
import myboot.app3.model.Post;
import myboot.app3.model.User;


@Service
@Transactional
public class PostManager {

    @PersistenceContext
    EntityManager em;
    
    
    public Post getPostByName(String name) {
        return em.find(Post.class, name);
    }

    public void removePost(String name) {
        Post Post = em.find(Post.class, name);
        if (Post != null) {
            em.remove(Post);
        }
    }
    
    
    public void createPost(String subject, User user, List<Comment> comments) {
        Post post = new Post();
        post.setUser(user);
        post.setSubject(subject);;
        post.setComments(comments);
        em.persist(post);
    }
 
 
}

