
package user;

import entities.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import repository.UserRepository;
import service.Authentication;

/**
 *
 * @author nazimelmardi
 */
@Named(value="userController")
@RequestScoped
public class UserController {

    private Authentication auth;
    private User user = new User();
    private UserRepository userRepository;

    
    public UserController() {
    }
    
    @Inject
    private HttpServletRequest servletRequest;

    @Inject
    public UserController(Authentication auth, UserRepository userRepository) {
        this.auth = auth;
        this.userRepository = userRepository;
    }
    
    public String register(){
        this.user.setId(1L);
        auth.register(user);
        return "/main.xhtml";
    }
    
    public String login (User user){
        try {
            servletRequest.getSession();
            servletRequest.login(user.getUsername(), user.getPassword());
            return "/user/forumentrylist.xhtml";
        } catch (ServletException ex) {
            return "/error.html";
        }
    }
    
    public String logout (){
        auth.logout();
        
        return "/main.xhtml";
    }
    
    public Authentication getAuth() {
        return auth;
    }

    public void setAuth(Authentication auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }


    
    
    
}
