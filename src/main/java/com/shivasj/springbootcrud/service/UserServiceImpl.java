package com.shivasj.springbootcrud.service;

import com.shivasj.springbootcrud.model.User;
import com.shivasj.springbootcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public void updateUser(User user) {
        User userDb = findUserById(user.getId());
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setAge(user.getAge());
        userRepository.save(userDb);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
