/*package controller;

import Services.userService;
import UML.User;
import exceptions.*;
import controller.dto.AuthDto;
import io.javalin.Javalin;
import io.javalin.http.*;
//no longer in use
import java.io.IOException;
import java.sql.SQLException;

public class userController {
    userService uServ;
    Javalin api;

    public userController(userService uServ, Javalin api){
        this.api = api;
        this.uServ = uServ;

        api.get("/login", this::login);
        api.get("/user/{username}", this::getUsers);
    }

    public void login(Context ctx) throws SQLException, NoSuchUserException, InvalidPasswordException{
        AuthDto auth = ctx.bodyAsClass(AuthDto.class);
        User res = null;
        try{
            res = uServ.login(auth.getUsername(), auth.getPassword());
            ctx.json(res);
            Cookie cookie = new Cookie("Auth", res.getUsername());
            ctx.cookie(cookie);
            ctx.status(200);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public User newUser(User user) throws SQLException, IOException, ClassNotFoundException {
        return uServ.makeUser(user);
    }

    public User getUsers(Context ctx) throws SQLException{
        return uServ.readUser(ctx.pathParam("username"));
    }
}*/
