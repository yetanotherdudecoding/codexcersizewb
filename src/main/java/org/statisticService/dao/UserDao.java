package org.statisticService.dao;

import org.statisticService.models.User;

import java.util.List;

public interface UserDao {

    void addOrUpdateUser(User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);
}
