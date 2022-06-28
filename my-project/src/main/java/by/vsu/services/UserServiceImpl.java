package by.vsu.services;

import java.util.List;
import java.util.stream.Collectors;

import by.vsu.dao.UserDao;
import by.vsu.models.User;
import by.vsu.util.CryptoUtil;
import lombok.AllArgsConstructor;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    
    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            return userDao.getUserById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public User getUserByLoginPassword(String login, String rawPassword) {
        try {
            String password = CryptoUtil.sha256(rawPassword);
            return userDao.getUserByLoginPassword(login, password);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public long addUser(User newUser) {
        try {
            validateAddUser(newUser);
            newUser.setPassword(CryptoUtil.sha256(newUser.getPassword()));
            newUser.setRoles(newUser.getRoles().stream().map(String::toLowerCase).collect(Collectors.toSet()));
            return userDao.addUser(newUser);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            validateUpdateUser(user);
            user.setPassword(CryptoUtil.sha256(user.getPassword()));
            user.setRoles(user.getRoles().stream().map(String::toLowerCase).collect(Collectors.toSet()));
            userDao.updateUser(user);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }        
    }

    @Override
    public void deleteUser(long id) {
        try {
            userDao.deleteUser(id);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }  
    }

    private void validateAddUser(User newUser) {
        requireNonNull(newUser.getLogin());
        requireNonNull(newUser.getPassword());
        requireNonNull(newUser.getRoles());
        if (userDao.getUserByLogin(newUser.getLogin()) != null) {
            throw new ServiceException("User \"" + newUser.getLogin() + "\" exists");
        }
    }

    private void validateUpdateUser(User user) {
        User existingUser = userDao.getUserByLogin(user.getLogin());
        if (existingUser != null && existingUser.getId() != user.getId()) {
            throw new ServiceException("User \"" + user.getLogin() + "\" exists");
        }
    }
}
