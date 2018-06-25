package service;

import entities.User;
import entities.UserRole;

/**
 *
 * @author nazimelmardi
 */
public interface Authentication {
    
    void login (User user);
    void logout();
    void register(User user);
    void registerWithRole(User user, UserRole role);
    
}
