package by.vsu.repositories;

import java.util.List;

import by.vsu.models.User;

public interface UserRepository {
    
    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByLogin(String login);

    User getUserByLoginPassword(String login, String password);

    long addUser(User newUser);

    void updateUser(User user);

    void deleteUser(long id);
}
