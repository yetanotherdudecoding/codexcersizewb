package dao.impls;

import dao.UserDao;
import models.User;

import java.util.ArrayList;


public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        database.add(new User(1, "the_brad524", "bradzxdf@gmail.com", "snakehill"));
        database.add(new User(2, "zerodown524", "zerofun@gmail.com", "lakehill"));

    }

    private ArrayList<User> database = new ArrayList<User>();


    public void addOrUpdateRecord(User user) {
        if(!database.contains(user)) {
            database.add(user);
        } else {
            database.remove(user);
            database.add(user);
        }
    }

    public void deleteRecord(User user) {
        database.remove(user);

    }

    public void deleteRecordByUserId(long id) {
        //TODO: This can be done with an iterator, but for prototyping, I'm just doing this
        User userToRemove = null;
        for (User aUser : database) {
            if (aUser.getUserId() == id) {
                userToRemove = aUser;
                break;
            }
        }
        if (userToRemove != null) {
            System.out.println("Removing record with id:" + id);
            database.remove(userToRemove);
        } else {
            System.out.println("I couldn't find a record with that id:" + id);
        }
    }

    public ArrayList<User> getAllRecords() {
        return database;
    }

    public User getUserById(long id) {
        for (User user : database) {
            if (user.getUserId() == id) {
                return user;
            }


        }
        return null;
    }
}
