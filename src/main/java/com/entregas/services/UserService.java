package com.entregas.services;

import com.entregas.entity.User;
import com.entregas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService() {

    }

    @Autowired
    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public List getAllUsers() {

        List userList = new ArrayList();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUserById(Long id) {

        User user = userRepository.findById(id).get();
        return user;
    }

    public boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception ex) {
            System.out.printf("[USERSERVICE][SAVEUSER] ERROR ON SAVE USER %s", ex.getMessage());
            return false;
        }
    }

    public boolean deleteUserById(Long id) {

        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            System.out.printf("[USERSERVICE][SAVEUSER] ERROR ON DELETE USER %s", ex.getMessage());
            return false;
        }
    }
}
