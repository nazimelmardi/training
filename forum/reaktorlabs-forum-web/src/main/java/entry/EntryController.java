package entry;

import entities.ForumEntry;
import static entry.Constants.MAX_ENTRY_PER_PAGE;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.EntryService;

/**
 *
 * @author nazimelmardi
 */

@Named(value="entryController")
@RequestScoped
public class EntryController {
    
    private List<ForumEntry> entries;
    private EntryService entryService;
    
    private ForumEntry entry;
    
    private HttpServletRequest request;

 
    public EntryController(){
        
    }

    @Inject
    public EntryController(EntryService entryService, HttpServletRequest request) {
        this.entryService=entryService;  
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    @PostConstruct   
    public void getForumEntriesInList(){
        this.entries = entryService.getAllEntryInList();
    }
    

    public List<ForumEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<ForumEntry> entries) {
        this.entries = entries;
    }

    public EntryService getEntryService() {
        return entryService;
    }

    public void setEntryService(EntryService entryService) {
        this.entryService = entryService;
    }

    public ForumEntry getEntry() {
        return entry;
    }

    public void setEntry(ForumEntry entry) {
        this.entry = entry;
    }
    
    

    
    
}
