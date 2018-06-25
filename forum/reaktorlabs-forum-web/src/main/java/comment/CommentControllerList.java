package comment;

import entities.ForumEntry;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.EntryService;

/**
 *
 * @author nazimelmardi
 */

@Named("commentControllerList")
@ViewScoped
public class CommentControllerList implements Serializable{
    
    private ForumEntry forumEntry;
    private EntryService service;

    public CommentControllerList() {
    }

    @Inject
    public CommentControllerList(EntryService service) {
        this.service = service;
    }
    
    
    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	Long id = Long.parseLong(params.get("entryid"));
        
        this.forumEntry = service.findEntry(id);
        
    }

    public ForumEntry getForumEntry() {
        return forumEntry;
    }

    public void setForumEntry(ForumEntry forumEntry) {
        this.forumEntry = forumEntry;
    }

    public EntryService getService() {
        return service;
    }

    public void setService(EntryService service) {
        this.service = service;
    }
    
    
    
}
