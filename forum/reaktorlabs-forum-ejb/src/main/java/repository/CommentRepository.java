package repository;

import entities.Comment;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class CommentRepository {
    
    @PersistenceContext (name = "com.reaktorlabs_reaktorlabs-forum-web_war_0.1PU")
    private EntityManager entityManager;
    
        
    public List<Comment> readAll(){
        TypedQuery<Comment>findAll = entityManager.createQuery("SELECT c FROM Comment c", Comment.class);
        
        return findAll.getResultList();
    }  
      
    public List<Comment> readAllCommentWriters(){          
   
        TypedQuery<Comment>findAllUserNames = entityManager.createQuery("SELECT c.username FROM Comment c", Comment.class);
        return findAllUserNames.getResultList();
    }
        
    public void create(Comment comment){
        entityManager.persist(comment);
    }
    
    public void update(Comment comment){
        entityManager.merge(comment);
    }
    
    public void delete(Comment comment){
        entityManager.remove(comment);
    }
}
