/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.User;
import java.util.List;

/**
 *
 * @author nazimelmardi
 */
public interface UserRepository {
    
    void create(User user);
    User read(Long id);
    List<User> findUserByName(String username);
    User update(User entity);
    User delete(User entity);
    User deleteById(Long id);


    
}
