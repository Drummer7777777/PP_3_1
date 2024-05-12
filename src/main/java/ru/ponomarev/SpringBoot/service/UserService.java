package ru.ponomarev.SpringBoot.service;


import ru.ponomarev.SpringBoot.models.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void add(User user);
    void remove(int id);
    void edit(User user);
    User getById(int id);
}
