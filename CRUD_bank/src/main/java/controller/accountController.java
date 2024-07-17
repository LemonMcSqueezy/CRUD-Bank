/*package controller;
//no longer in use
import UML.*;
import exceptions.*;
import Services.*;
import dao.*;

import io.javalin.Javalin;
import io.javalin.http.*;

import java.sql.SQLException;


public class accountController {
    accountService aServ;
    transactionService tServ;
    userService uServ;
    Javalin api;

    public accountController(accountService aServ, transactionService tServ, userService uServ, Javalin api){
        this.aServ = aServ;
        this.tServ = tServ;
        this.uServ = uServ;
        this.api = api;

        api.post("/accounts/{uID}", this::makeAcct);
    }

    public void makeAcct(Context ctx) throws SQLException{
        int uid = Integer.parseInt(ctx.pathParam("uID"));
        User temp = new User(uid);
        Account aTemp = aServ.makeAccount();

    }

}*/
