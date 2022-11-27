package myboot.app3.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myboot.app3.model.Comment;
import myboot.app3.model.Post;
import myboot.app3.model.User;


@Service
@Transactional
public class CommentManager {

    @PersistenceContext
    EntityManager em;
    
    
    public Comment getCommentByName(String name) {
        return em.find(Comment.class, name);
    }

    public void removeComment(String name) {
        Comment Comment = em.find(Comment.class, name);
        if (Comment != null) {
            em.remove(Comment);
        }
    }

    public void createComment(String reply, User user, Post post) {
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setReply(reply);
        em.persist(comment);
    }
 
}

