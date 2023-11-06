package service;

import java.util.List;

public interface UserService {
    boolean register(User user);

    List<User> getAll();

    boolean login(String username, String password);

    User viewCurrentUserInfo();

    void logout();
}
