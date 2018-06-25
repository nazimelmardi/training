package comment;

import entities.Comment;
import entities.ForumEntry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.CommentService;
import service.EntryService;

/**
 *
 * @author nazimelmardi
 */
@Named(value = "commentSave")
@ViewScoped
public class CommentControllerSave implements Serializable{
    
    private Comment comment = new Comment();
    private CommentService commentService;
    private ForumEntry entry;
    private List<Comment>comments = new ArrayList<>();
    private EntryService entryService;

    public CommentControllerSave() {
    }

    @Inject
    public CommentControllerSave(CommentService commentService,EntryService entryService) {
        this.commentService = commentService;
        this.entryService = entryService;
    }
       
    
       
    public String saveComment(ForumEntry forumEntry, HttpServletRequest request){     
        String time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
        comment.setDate(time);
        comment.setUsername(getLoggedInUserName(request));
        comment.setForumEntry(forumEntry);
        commentService.saveComment(comment);
        ForumEntry forumEntry1 = entryService.findEntry(forumEntry.getId());
        for(Comment onecomment : forumEntry1.getCommentList()) {
            this.comments.add(onecomment);
        }
        String urlAddress = request.getRequestURL().toString();
        String akarmi = entry.getId().toString();
        String tryout = urlAddress+"?entryid="+akarmi;
        System.out.println(tryout);
        return tryout;
    }
    
    @PostConstruct
    public void getInst(){
                            
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	Long id = Long.parseLong(params.get("entryid"));
        
        
        this.entry = entryService.findEntry(id);
    }
        
    public String getLoggedInUserName(HttpServletRequest request){
        String uName = request.getUserPrincipal().getName();
        return uName;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }


    public EntryService getEntryService() {
        return entryService;
    }

    public void setEntryService(EntryService entryService) {
        this.entryService = entryService;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
        



    
}

