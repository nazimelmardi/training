
package service;

import entities.ForumEntry;
import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import repository.ForumEntryRepository;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class EntryServiceImpl implements EntryService{
    

    
    private ForumEntryRepository repository;
    
    public EntryServiceImpl() {
    }
    
    @Inject
    public EntryServiceImpl(ForumEntryRepository repository){
        this.repository = repository;
    }
    
    @Override
    public List<ForumEntry> getAllEntryInList() {
        return repository.readAll();
    }

    @Override
    public void saveForumEntry(ForumEntry forumEntry) {
        this.repository.create(forumEntry);   
    }

    @Override
    public void updateEntry(Long forumEntryId, String entryText) {
        ForumEntry updateEntry = this.repository.findEntry(forumEntryId).get(0);
        updateEntry.setEntryText(entryText);
        this.repository.merge(updateEntry);
    }

    @Override
    public ForumEntry findEntry(Long forumEntryId) {
        ForumEntry forumEntry = this.repository.findEntry(forumEntryId).get(0);
        return forumEntry;
    }
    
    
}
