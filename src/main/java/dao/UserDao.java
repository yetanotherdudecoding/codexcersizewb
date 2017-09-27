package dao;

import models.User;

import java.util.ArrayList;

public interface UserDao {

    void addOrUpdateRecord(User user);

    void deleteRecord(User user);

    void deleteRecordByUserId(long id);

    ArrayList<User> getAllRecords();

    User getUserById(long id);
}
