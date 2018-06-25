package service;

import entities.ForumEntry;
import java.util.List;

/**
 *
 * @author nazimelmardi
 */
public interface EntryService {
    
    List<ForumEntry> getAllEntryInList();
        
    void saveForumEntry(ForumEntry forumEntry);
    
    void updateEntry(Long forumEntryId, String entryText);
    
    ForumEntry findEntry (Long forumEntryId);
    
}
