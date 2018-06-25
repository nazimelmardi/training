package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nazimelmardi
 */
@Entity
@Table(name = "forum_entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForumEntry.findAll", query = "SELECT f FROM ForumEntry f")})
public class ForumEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "entry_text")
    private String entryText;
    @NotNull
    @Column(name = "dateandtime")
    private String date;
    @Column(name = "username")
    private String username;
    
    @OneToMany(mappedBy = "forumEntry",fetch = FetchType.EAGER)
    private List<Comment>commentList = new ArrayList<>();

    public ForumEntry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntryText() {
        return entryText;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "ForumEntry{" + "id=" + id + ", title=" + title + ", entryText=" + entryText + ", date=" + date + ", username=" + username + ", commentList=" + commentList + '}';
    }

    
}
