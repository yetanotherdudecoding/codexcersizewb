package org.statisticService.controllers;


import org.statisticService.models.User;
import org.statisticService.dao.UserDao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addUser(@Valid @RequestBody User aUser, BindingResult result,
                        HttpServletRequest request) {
        System.out.println("Received request to add user:" + aUser);
        userDao.addOrUpdateUser(aUser);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @RequestMapping(value = "/viewUser/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    User viewUser(@PathVariable(name = "userId") long userId) {
        return userDao.getUserById(userId);
    }

    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "userId") long userId) {
        userDao.deleteUserById(userId);
    }

}
