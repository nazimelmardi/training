package service;

import entities.User;
import entities.UserRole;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import repository.UserRepository;
import java.util.logging.Logger;
import util.HashUtil;

/**
 *
 * @author nazimelmardi
 */

@Stateless
public class AuthService implements Authentication{
    
    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());
    
    private UserRepository userRepository;
    
    private HttpServletRequest servletRequest;

    public AuthService() {
    }

    @Inject
    public AuthService(UserRepository userRepository, HttpServletRequest servletRequest) {
        this.userRepository = userRepository;
        this.servletRequest = servletRequest;
    }

    @Override
    public void login(User user) {
        
        try{
            servletRequest.getSession();
            servletRequest.login(user.getUsername(), user.getPassword());
        }catch(ServletException e){
            LOGGER.warning(e.getMessage());
        }
        
    }

    @Override
    public void logout() {
        
        try{
            servletRequest.getSession();
            servletRequest.logout();
        }catch(ServletException e){
            LOGGER.warning(e.getMessage());
        }
    }

    @Override
    public void register(User user) {
        
        if(userRepository.findUserByName(user.getUsername()).isEmpty()){
            final UserRole defaultRole = new UserRole();
            defaultRole.setName("user");
            defaultRole.setUser(user);
            registerWithRole(user,defaultRole);
        }else{
            throw new IllegalStateException("This user is there");
        }
    }

    @Override
    public void registerWithRole(User user, UserRole role) {
        final User newUser = new User();
        final String password = user.getPassword();
        final String secretPassword = HashUtil.encryptSHA512(password);
        newUser.setUsername(user.getUsername());
        newUser.setPassword(secretPassword);
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setDescription(user.getDescription());
        final List<UserRole> roles = new ArrayList<>();
        roles.add(role);
        newUser.setRoles(roles);
        userRepository.create(newUser);
    }
    
    
}
