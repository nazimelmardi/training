package service;

import entities.Comment;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import repository.CommentRepository;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class CommentService {
    
    private CommentRepository repository;
    
    public CommentService() {
    }
    
    @Inject
    public CommentService(CommentRepository repository){
        this.repository = repository;
    }

    
    public void saveComment(Comment comment) {
        this.repository.create(comment);   
    }
    
    public List<Comment> getAllCommentInList() {
        System.out.print(repository.readAll());
        return repository.readAll();
    }
    
       
//    public List<Comment> getAllCommentText() {
//        return repository.readAllCommentTexts();
//    }
    
//    public List<Comment>allCommentsOfForumEntry(long forumEntryId){
//        return repository.listAllCommentsOfForumEntry(forumEntryId);
//    }
       
    public List<Comment> getAllCommentWriter() {
        return repository.readAllCommentWriters();
    }
    
    public void updateComment(Comment comment){
        this.repository.update(comment);
    }
    
    public void deleteComment(Comment comment){
        this.repository.delete(comment);
    }
    
}
