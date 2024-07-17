package dao;
import java.sql.*;
import java.io.IOException;
import UML.User;
import utils.connectionUtil;

public class userDao {
    //private final Connection connection;

    public userDao(){

    }

    /*public userDao(Connection connection) throws SQLException, IOException, ClassNotFoundException {
        this.connection = connectionUtil.getConnection();
    }*/

    public void registration(User user) throws SQLException, IOException, ClassNotFoundException {
        if(user.getuID() == null){
            Connection connection = connectionUtil.getConnection();
            String sql = "INSERT INTO users (fname, lname, email, phoneNo, username, pwd) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getFname());
            pstmt.setString(2, user.getLname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhoneNo());
            pstmt.setString(5, user.getUsername());
            pstmt.setString(6, user.getPassword());
            pstmt.executeUpdate();
            ResultSet dbKey = pstmt.getGeneratedKeys();
            if(dbKey.next()){
                user.setuID(dbKey.getInt(1));
            }
        }
        else{
            Connection connection = connectionUtil.getConnection();
            String sql = "UPDATE users SET fname = ? , lname = ? , email = ? , phoneNo = ? , username = ? , password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getFname());
            pstmt.setString(2, user.getLname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhoneNo());
            pstmt.setString(5, user.getUsername());
            pstmt.setString(6, user.getPassword());
            pstmt.executeUpdate();
        }
    }

    public User fetchUser(String username) throws SQLException, IOException, ClassNotFoundException {
        User user = new User();
        Connection connection = connectionUtil.getConnection();
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet results = pstmt.executeQuery();
        if(results.next()){
            user.setuID(results.getInt("uID"));
            user.setFname(results.getString("fname"));
            user.setLname(results.getString("lname"));
            user.setEmail(results.getString("email"));
            user.setPhoneNo(results.getString("phoneNo"));
            user.setUsername(results.getString("username"));
            user.setPassword(results.getString("pwd"));
        }
        return user;
    }

    public User getUserById(Integer uID) throws SQLException, IOException, ClassNotFoundException {
        User user = new User();
        Connection connection = connectionUtil.getConnection();
        String sql = "SELECT * FROM users WHERE uID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, uID);
        ResultSet results = pstmt.getGeneratedKeys();
        if(results.next()){
            user.setFname(results.getString("fname"));
            user.setLname(results.getString("lname"));
            user.setEmail(results.getString("email"));
            user.setPhoneNo(results.getString("phoneNo"));
            user.setUsername(results.getString("username"));
            user.setPassword(results.getString("pwd"));
        }
        return user;
    }

    public User update(User user) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE users SET fname = ? , lname = ? , email = ? , phoneNo = ? , username = ? , password = ?";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, user.getFname());
        pstmt.setString(2, user.getLname());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getPhoneNo());
        pstmt.setString(5, user.getUsername());
        pstmt.setString(6, user.getPassword());
        pstmt.executeUpdate();
        return user;
    }

    public void delete(User user) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM users where userId = ?";
        Connection connection = connectionUtil.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, user.getuID());
        pstmt.executeUpdate();
    }
}
