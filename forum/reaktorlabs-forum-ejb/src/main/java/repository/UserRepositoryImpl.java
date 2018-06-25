/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class UserRepositoryImpl implements UserRepository{
    
    @PersistenceContext (name = "com.reaktorlabs_reaktorlabs-forum-web_war_0.1PU")
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User read(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> findUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    @Override
    public User update(User entity) {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User delete(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public User deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
