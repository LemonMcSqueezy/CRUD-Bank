package Services;
import UML.User;
import dao.userDao;
import UML.User;

import java.io.IOException;
import java.sql.SQLException;
import exceptions.*;

public class userService {
    userDao udao;

    public userService(){

    }

    public userService(userDao udao){
        this.udao = udao;
    }

    public User makeUser(User user) throws SQLException, IOException, ClassNotFoundException {
        udao.registration(user);
        return user;
    }

    public User login(String username, String password) throws SQLException, IOException, ClassNotFoundException, InvalidPasswordException {
        User user = udao.fetchUser(username);
        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            throw new InvalidPasswordException("Incorrect password.");
        }
    }

    public void newUser(String fname, String lname, String email, String phoneNo, String username, String password){
        User toRegister = new User(fname, lname, email, phoneNo, username, password);
        try{
            udao.registration(toRegister);
        } catch (SQLException | IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public User readUserByID(Integer uID){
        User currUser = new User();
        try{
            currUser = udao.getUserById(uID);
        } catch (SQLException | IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return currUser;
    }

    public User readUser(String ppi){
        User currUser = new User();
        try{
            currUser = udao.fetchUser(ppi);
        } catch (SQLException | IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return currUser;
    }

    public User updateUser(User user){
        try{
            return udao.update(user);
        } catch(SQLException | IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void delUser(User user){
        try{
            udao.delete(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
