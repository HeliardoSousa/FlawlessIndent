package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
import util.DbUtil;
 
public class UserDAO {
 
    private static Connection connection = DbUtil.getConnection();
 
    public static User addUser(String login, String password, String nome, String sobrenome) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("insert into users(login, password, nome, sobrenome) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, login);
            pStmt.setString(2, password);
            pStmt.setString(3, nome);
            pStmt.setString(4, sobrenome);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("sobrenome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static User updateUser(int id, String login, String password, String nome, String sobrenome) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("update users set login=?, password=?, nome=?, sobrenome=? where id=?",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, login);
            pStmt.setString(2, password);
            pStmt.setString(3, nome);
            pStmt.setString(4, sobrenome);
            pStmt.setInt(5, id);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("sobrenome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static void deleteUser(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users order by id");
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("sobrenome"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return users;
    }
 
    public static User getUser(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("sobrenome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
 
    public static User getUserByLogin(String login) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("select * from users where login=?");
            pStmt.setString(1, login);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("sobrenome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
}