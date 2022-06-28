package by.vsu.services;

import java.util.List;

import by.vsu.models.User;

public interface UserService {
    
    List<User> getAllUsers();

    User getUserById(long id);

    long addUser(User newUser);

    User getUserByLoginPassword(String login, String rawPassword);

    void updateUser(User user);

    void deleteUser(long id);
}
