package ru.ponomarev.SpringBoot.dao;

import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import ru.ponomarev.SpringBoot.models.User;

import java.util.List;

//@Repository
public class UserDaoImpl implements UserDao{
//    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }
}
