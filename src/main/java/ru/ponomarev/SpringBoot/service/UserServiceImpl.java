package ru.ponomarev.SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ponomarev.SpringBoot.dao.UserDao;
import ru.ponomarev.SpringBoot.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    @Qualifier("jpaUserDao")
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}

