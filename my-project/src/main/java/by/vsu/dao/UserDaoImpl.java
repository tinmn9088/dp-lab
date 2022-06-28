package by.vsu.dao;

import java.util.List;

import by.vsu.models.User;
import by.vsu.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.getAllUsers();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            return userRepository.getUserById(id);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            return userRepository.getUserByLogin(login);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        try {
            return userRepository.getUserByLoginPassword(login, password);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public long addUser(User newUser) {
        try {
            return userRepository.addUser(newUser);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userRepository.updateUser(user);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteUser(long id) {
        try {
            userRepository.deleteUser(id);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
