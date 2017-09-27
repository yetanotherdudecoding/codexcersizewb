package controllers;


import dao.impls.UserDaoImpl;
import models.User;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

@Controller
public class UserController {

    UserDaoImpl userDB = new UserDaoImpl();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addUser(@Valid @RequestBody User aUser, BindingResult result,
                        HttpServletRequest request) {
    System.out.println("Received request to add user:" + aUser);
        userDB.addOrUpdateRecord(aUser);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public @ResponseBody ArrayList<User> getAllUsers() {
        return userDB.getAllRecords();
    }

    @RequestMapping(value = "/viewUser/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User viewUser(@PathVariable(name = "id") long id) {
        return userDB.getUserById(id);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id") long id) {
        userDB.deleteRecordByUserId(id);
    }

}
