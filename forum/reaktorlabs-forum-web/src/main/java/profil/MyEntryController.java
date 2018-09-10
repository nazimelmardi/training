package profil;

import entities.ForumEntry;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.EntryService;
import service.ProfileService;

/**
 *
 * @author nazimelmardi
 */
@Named(value="myEntryController")
@RequestScoped
public class MyEntryController implements Serializable {
    
    private List<ForumEntry> entries;
    private EntryService entryService;
    private HttpServletRequest request;
    private ProfileService profileService;

    public MyEntryController() {
    }

    @Inject
    public MyEntryController(ProfileService profileService, HttpServletRequest request) {
        this.profileService = profileService;
        this.request = request;
    }
    
    //@PostConstruct
    public List<ForumEntry>forumEntryList(){
        List<ForumEntry> entries = profileService.getEntriesOfUser();
        return entries;
    }

   

}
