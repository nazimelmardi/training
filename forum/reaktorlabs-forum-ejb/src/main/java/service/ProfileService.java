package service;

import entities.ForumEntry;
import java.util.List;
import javax.inject.Inject;
import repository.ForumEntryRepository;

/**
 *
 * @author nazimelmardi
 */
public class ProfileService {
    
    ForumEntryRepository repository;

    public ProfileService() {
    }

    @Inject
    public ProfileService(ForumEntryRepository repository) {
        this.repository = repository;
    }
          
    public List<ForumEntry> getEntriesOfUser() {
        return repository.();
    
}
