package service;

import entity.Cart;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    public static List<User> userList = new ArrayList<User>();
    public static User currentUser;
    @Override
    public boolean register(User user) {
        userList.add(user);
        return true;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public boolean login(String username, String password) {
        for (User user : userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public User viewCurrentUserInfo() {
        return currentUser;
    }

    @Override
    public void logout() {
        currentUser = null;
        Object cart = null;
    }
}
