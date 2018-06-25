package profil;

import entities.ForumEntry;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.EntryService;

/**
 *
 * @author nazimelmardi
 */
@Named(value="myEntryController")
@RequestScoped
public class MyEntryController implements Serializable{
    
    private List<ForumEntry> entries;
    private EntryService entryService;
    private HttpServletRequest request;

    public MyEntryController() {
    }

    


}
