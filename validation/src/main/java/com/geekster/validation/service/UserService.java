package com.geekster.validation.service;

import com.geekster.validation.model.User;
import com.geekster.validation.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        userDao.AddUser(user);
    }

    public List<User> getAllUsers() {
       return  userDao.getAll();
    }


    public User getUserById(int userid) {
        List<User> helperList = getAllUsers();
        for ( User user : helperList ) {
            if ( user.getUserId()==(userid) ) {
                return user;
            }
        }
        return null;
    }

    public String deleteUserById(int userId) {
        List<User> helperList = getAllUsers();
        Boolean status = false;

        for ( User user : helperList ) {
            if ( user.getUserId()==(userId) ) {
                status = userDao.removeUserById(user);
                if ( status ) {
                    return "User " + userId + " removed from database successfully!!!";
                }
                else {
                    return "User " + userId + " cannot be removed from database (Database error)!!!";
                }
            }
        }
        return "User " + userId + " Not Found!!!";
    }

    public String updateUser(int userId, User user ) {
        boolean updateStatus =  userDao.updateUserById(userId,user);

        if(updateStatus)
        {
            return "User: " + userId + " was updated!!!";
        }
        else
        {
            return "User: " + userId + " does not exist!!!";
        }
    }
}
