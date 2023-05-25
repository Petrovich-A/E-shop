package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.model.User;
import by.petrovich.eshop.repository.UserRepository;
import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        User userSaved = new User();
        if (!isExist(user.getEmail())) {
            return userRepository.save(user);
        } else {
// TODO: 25.05.2023
        }
        return userSaved;
    }

    private boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }


}
