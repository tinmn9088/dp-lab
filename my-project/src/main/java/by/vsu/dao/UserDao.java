package by.vsu.dao;

import java.util.List;

import by.vsu.models.User;

public interface UserDao {
    
    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByLogin(String login);

    long addUser(User newUser);

    User getUserByLoginPassword(String login, String password);

    void updateUser(User user);

    void deleteUser(long id);
}
