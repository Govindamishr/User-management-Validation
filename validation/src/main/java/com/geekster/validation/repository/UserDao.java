package com.geekster.validation.repository;

import com.geekster.validation.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class UserDao {
    List<User> list=new ArrayList<User>();

    public String AddUser(User user){
        list.add(user);
        return "Add success";
    }

    public List<User> getAll(){
        return list;
    }

    public Boolean updateUserById(int userId, User user) {
        for ( User userObj : list ) {
            if ( userObj.getUserId()==(userId) ) {
                userObj.setUserName(user.getUserName());
                userObj.setEmail(user.getEmail());
                userObj.setDateOfBirth(user.getDateOfBirth());
                userObj.setPhoneNumber(user.getPhoneNumber());
                userObj.setDate (user.getDate());
                userObj.setTime (user.getTime());

                return true;
            }
        }
        return false;
    }

    public Boolean removeUserById(User user) {
        list.remove(user);
        return true;
    }




}
