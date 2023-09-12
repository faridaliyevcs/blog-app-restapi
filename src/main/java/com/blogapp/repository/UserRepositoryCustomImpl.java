package com.blogapp.repository;

import com.blogapp.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryCustomImpl {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    public void deleteUserByUserId(int id) {
        User userToDelete = entityManager.find(User.class, id);
        if(userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }

    public User updateNewUser(User newUser) {
        User user = entityManager.find(User.class, newUser.getId());
        if(user != null) {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setLikes(newUser.getLikes());
            user.setBirthDate(newUser.getBirthDate());
            entityManager.merge(user);
            return user;
        }
        return null;
    }

    public User getUserByUserId(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

}
