package entry;

import entities.ForumEntry;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

@Named(value="entryControllerSave")
@RequestScoped
public class EntryControllerSave {
    
    private ForumEntry forumEntry = new ForumEntry();
    private EntryService forumEntryService;
    

    public EntryControllerSave() {
    }
    
    @Inject
    public EntryControllerSave(EntryService forumEntryService){
        this.forumEntryService = forumEntryService;
    }

     
    public String saveDateAndUsername(HttpServletRequest request){     
        String time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
        forumEntry.setDate(time);
        forumEntry.setUsername(getLoggedInUserName(request));
        forumEntryService.saveForumEntry(forumEntry);
        return "/user/forumentrylist.xhtml";
    }
    
    
    public String getLoggedInUserName(HttpServletRequest request){
        String uName = request.getUserPrincipal().getName();
        return uName;
    }
        
    
    //Getter-Setter

    public ForumEntry getForumEntry() {
        return forumEntry;
    }

    public void setForumEntry(ForumEntry forumEntry) {
        this.forumEntry = forumEntry;
    }

    public EntryService getForumEntryService() {
        return forumEntryService;
    }

    public void setForumEntryService(EntryService forumEntryService) {
        this.forumEntryService = forumEntryService;
    }

    
    

    
    
}
