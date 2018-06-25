package repository;

import entities.ForumEntry;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class ForumEntryRepository {
    
    @PersistenceContext (name = "com.reaktorlabs_reaktorlabs-forum-web_war_0.1PU")
    private EntityManager entityManager;

    public ForumEntryRepository() {
    }

        
    public List<ForumEntry> readAll(){
        TypedQuery<ForumEntry>findAllEntries = entityManager.createQuery("SELECT e FROM ForumEntry e", ForumEntry.class);
        
        return findAllEntries.getResultList();
    }
    
    public void create(ForumEntry forumEntry){
        entityManager.persist(forumEntry);
    }
    
    public void merge(ForumEntry forumEntry){
        entityManager.merge(forumEntry);
    }
    
    public List<ForumEntry> findEntry (Long forumEntryId){
        TypedQuery<ForumEntry>findEntry = entityManager.createQuery("SELECT e FROM ForumEntry e WHERE e.id=:id", ForumEntry.class);
        findEntry.setParameter("id", forumEntryId);
        return findEntry.getResultList();
    }
    
    public List<ForumEntry> findEntryOfUser (String username){
        TypedQuery<ForumEntry> query = entityManager.createQuery("SELECT e FROM ForumEntry e WHERE e.username=:username",ForumEntry.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

 
}
