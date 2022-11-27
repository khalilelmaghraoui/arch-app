package myboot.app2.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myboot.app2.model.Counter;

@Service
@Transactional
public class CounterRemover {

    @PersistenceContext
    EntityManager em;

    public void removeCounter(String name) {
        Counter c = em.find(Counter.class, name);
        if (c != null) {
            em.remove(c);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void removeCounterAndCommit(String name) {
        Counter c = em.find(Counter.class, name);
        if (c != null) {
            em.remove(c);
        }
    }

}