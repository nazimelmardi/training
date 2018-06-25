package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nazimelmardi
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "comment_text")
    private String commentText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateandtime")
    private String date;
    @NotNull
    @Column(name = "username")
    private String username;  
    @ManyToOne
    @JoinColumn(name = "forum_entry_id")
    private ForumEntry forumEntry;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ForumEntry getForumEntry() {
        return forumEntry;
    }

    public void setForumEntry(ForumEntry forumEntry) {
        this.forumEntry = forumEntry;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", commentText=" + commentText + ", date=" + date + ", username=" + username + ", forumEntry=" + forumEntry + '}';
    }




    
    
}
