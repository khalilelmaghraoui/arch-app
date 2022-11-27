package myboot.app3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import myboot.app3.model.Post;
import myboot.app3.model.User;
import myboot.app3.services.CommentManager;
import myboot.app3.services.PostManager;
import myboot.app3.services.UserManager;


@SpringBootTest
@Rollback(false)
public class TestUserManager {

    @Autowired
    public UserManager um;
    
    @Autowired
    public CommentManager cm;
    
    @Autowired
    public PostManager pm;

   
    
    @TestMethodOrder(OrderAnnotation.class)
    public class OrderAnnotationUnitTest {
        
        @Test
        @Order(1)    
        public void testCreatUser() {
            um.createUser("mario", "gmail");
            User c = um.getUserByName("mario");
            assertEquals("gmail", c.getEmail());
        }
        
        @Test
        @Order(2)    
        public void testCreatPost() {
        	User u = um.getUserByName("mario");
            pm.createPost("sport", u, null);
            Post p = pm.getPostByName("sport");
            assertEquals("mario", p.getUser().getName());
        }
     
       
        
    }
}