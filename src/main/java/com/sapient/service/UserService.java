package com.sapient.service;


import com.sapient.entity.User;

import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
public interface UserService {

    User get(UUID uuid) throws Exception;
    List<User> search(String pattern);
    List<User> getAll();
    User save(User movie);
    User update(User movie);
    boolean delete(UUID id) throws Exception;
}
