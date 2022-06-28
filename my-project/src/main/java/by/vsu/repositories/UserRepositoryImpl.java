package by.vsu.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import by.vsu.models.User;
import by.vsu.util.ConfigProvider;

public class UserRepositoryImpl implements UserRepository {

    private final static String URL = ConfigProvider.getValue("db.url");

    private final static String USER = ConfigProvider.getValue("db.user");
    
    private final static String PASSWORD = ConfigProvider.getValue("db.password");

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }
    
    @Override
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, login, password, roles FROM users");  
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                if (rs.getString(4) != null) {
                    Set<String> roles = new HashSet<>(List.of(rs.getString(4).split(",")));
                    user.setRoles(roles);
                }
                users.add(user);
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
        return users;
    }

    @Override
    public User getUserById(long id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, login, password, roles FROM users WHERE id = '" + id + "'");  
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                if (rs.getString(4) != null) {
                    Set<String> roles = new HashSet<>(List.of(rs.getString(4).split(",")));
                    user.setRoles(roles);
                }
                return user;
            } else {
                return null;
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
    }

    @Override
    public User getUserByLogin(String login) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, login, password, roles FROM users WHERE login = '" + login + "'");  
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                if (rs.getString(4) != null) {
                    Set<String> roles = new HashSet<>(List.of(rs.getString(4).split(",")));
                    user.setRoles(roles);
                }
                return user;
            } else {
                return null;
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, login, password, roles FROM users WHERE login = '" 
                    + login + "' AND password='" + password + "'");  
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                if (rs.getString(4) != null) {
                    Set<String> roles = new HashSet<>(List.of(rs.getString(4).split(",")));
                    user.setRoles(roles);
                }
                return user;
            } else {
                return null;
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
    }

    @Override
    public long addUser(User newUser) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            PreparedStatement stmt = con.prepareStatement("INSERT INTO users (login, password, roles) VALUES (?, ?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
            if (newUser.getLogin() != null) {
                stmt.setString(1, newUser.getLogin());
            } else {
                stmt.setNull(1, Types.NVARCHAR);
            }
            if (newUser.getPassword() != null) {
                stmt.setString(2, newUser.getPassword());
            } else {
                stmt.setNull(2, Types.NVARCHAR);
            }
            if (newUser.getRoles() != null) {
                stmt.setString(3, String.join(",", newUser.getRoles()));
            } else {
                stmt.setNull(3, Types.NVARCHAR);
            }
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                PreparedStatement stmt = con.prepareStatement("UPDATE users SET login = ?, password = ?, roles = ? WHERE id = '" + user.getId() + "'");
                if (user.getLogin() != null) {
                    stmt.setString(1, user.getLogin());
                } else {
                    stmt.setNull(1, Types.NVARCHAR);
                }
                
                stmt.setString(2, user.getPassword());
                if (user.getRoles() != null) {
                    stmt.setString(3, String.join(",", user.getRoles()));
                } else {
                    stmt.setNull(3, Types.NVARCHAR);
                }
                stmt.executeUpdate();
            } else {
                PreparedStatement stmt = con.prepareStatement("UPDATE users SET login = ?, roles = ? WHERE id = '" + user.getId() + "'");
                if (user.getLogin() != null) {
                    stmt.setString(1, user.getLogin());
                } else {
                    stmt.setNull(1, Types.NVARCHAR);
                }
                if (user.getRoles() != null) {
                    stmt.setString(2, String.join(",", user.getRoles()));
                } else {
                    stmt.setNull(2, Types.NVARCHAR);
                }
                stmt.executeUpdate();
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }

    @Override
    public void deleteUser(long id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt = con.createStatement();  
            stmt.executeUpdate("DELETE FROM users WHERE id = '" + id + "'");  
        } catch (Exception e) { 
            throw new RepositoryException(e);
        } 
    }
}
