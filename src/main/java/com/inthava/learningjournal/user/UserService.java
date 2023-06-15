package com.inthava.learningjournal.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void creatUser(User user) {
        userRepository.save(user);
    }

    public User isValidUser(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.orElse(null);
    }

    public User getUserInformation(String username) {
        return userRepository.findByUsername(username);
    }

    public void updatePassword(Long id, String password) {
        userRepository.updatePassword(id, password);
    }
}
