package org.statisticService.dao.impls;

import org.statisticService.models.User;
import org.statisticService.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public void addOrUpdateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();
    }

//    public void deleteUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
//        session.flush();
//
//    }

    public void deleteUserById(long userId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getUserById(userId));
        session.flush();


    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        session.flush();

        return users;
    }

    public User getUserById(long userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, userId);
        session.flush();

        return user;
    }
}
