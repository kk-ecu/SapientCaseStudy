package com.sapient.service;

import com.sapient.entity.User;
import com.sapient.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(UUID uuid) throws Exception {
        Optional<User>movie=this.userRepository.findById(uuid);
        if (movie.isPresent()){
            throw new Exception("No Movie is Available");
        }
        return movie.get();
    }

    @Override
    public List<User> search(String pattern) {
        Iterable<User> iterable= this.userRepository.findAll();
        List<User> users=new ArrayList<>();

        iterable.forEach(user -> {
            if (user.getFirstName().contains(pattern)) {
            users.add(user);
            }
            });
        return users;
    }

    @Override
    public List<User> getAll() {
        List<User> users=new ArrayList<>();
        this.userRepository.findAll().forEach(movie -> {
            users.add(movie);
        });
    return users;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        this.userRepository.delete(this.get(id));
        return true ;
    }
}
