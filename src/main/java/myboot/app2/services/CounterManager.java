package myboot.app2.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myboot.app2.model.Counter;

@Service
@Transactional
public class CounterManager {

    @PersistenceContext
    EntityManager em;
    
    @Autowired
    CounterRemover remover;

    public Counter getCounter(String name) {
        return em.find(Counter.class, name);
    }

    public void removeCounter(String name) {
        Counter c = em.find(Counter.class, name);
        if (c != null) {
            em.remove(c);
        }
    }

    public void createCounter(String name, Integer value) {
        removeCounter(name);
        Counter c = new Counter();
        c.setName(name);
        c.setValue(value);
        em.persist(c);
    }
    
    public void doubleSave(Counter c1, Counter c2) {
        em.persist(c1);
        em.persist(c2);
    }
    
    @Transactional(rollbackFor = BadCounter.class)
    public void createValidCounter(String name, Integer value) throws BadCounter {
        removeCounter(name);
        Counter c = new Counter();
        c.setName(name);
        c.setValue(value);
        em.persist(c);
        if (value < 0) {
            throw new BadCounter();
        }
    }
    
  

	
	  @Transactional(rollbackFor = BadCounter.class) public void
	  createCounter2(String name, Integer value) throws BadCounter {
		  remover.removeCounter(name); 
		  Counter c = new Counter(); 
		  c.setName(name);
		  c.setValue(value); em.persist(c); 
		  if (value < 0) { 
			  throw new BadCounter(); 
			  }
	  }
	 
    @Transactional(rollbackFor = BadCounter.class)
    public void removeAndCreateCounter(String name, Integer value)
    throws BadCounter {
        remover.removeCounterAndCommit(name);
        Counter c = new Counter();
        c.setName(name);
        c.setValue(value);
        em.persist(c);
        if (value < 0) {
            throw new BadCounter();
        }
    }
    
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getCounterValue(String name) {
        Counter c =  em.find(Counter.class, name);
        return c.getValue();
    }
    
    @Transactional(propagation = Propagation.MANDATORY)
    public Integer getCounterValue2(String name) {
        Counter c =  em.find(Counter.class, name);
        Integer value = c.getValue(); 
        return value;
    }
}

