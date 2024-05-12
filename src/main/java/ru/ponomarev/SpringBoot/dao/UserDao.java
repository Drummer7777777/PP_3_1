package ru.ponomarev.SpringBoot.dao;


import ru.ponomarev.SpringBoot.models.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void add(User user);
    void remove(int id);
    void edit(User user);
    User getById(int id);
}
