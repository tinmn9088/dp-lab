package by.vsu.services;

import java.util.List;

import by.vsu.dao.UserDao;
import by.vsu.models.User;
import by.vsu.util.CryptoUtil;
import lombok.AllArgsConstructor;

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
    public boolean validatePassword(String login, String rawPassword) {
        try {
            String password = CryptoUtil.sha256(rawPassword);
            return userDao.getUserByLoginPassword(login, password) != null;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public long addUser(User newUser) {
        try {
            newUser.setPassword(CryptoUtil.sha256(newUser.getPassword()));
            return userDao.addUser(newUser);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            user.setPassword(CryptoUtil.sha256(user.getPassword()));
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
}
