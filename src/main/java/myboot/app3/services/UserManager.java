package myboot.app3.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myboot.app3.model.User;


@Service
@Transactional
public class UserManager {

    @PersistenceContext
    EntityManager em;
    
    
    public User getUserByName(String name) {
        return em.find(User.class, name);
    }

    public void removeUser(String name) {
        User user = em.find(User.class, name);
        if (user != null) {
            em.remove(user);
        }
    }

    public void createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        em.persist(user);
    }
 
}

