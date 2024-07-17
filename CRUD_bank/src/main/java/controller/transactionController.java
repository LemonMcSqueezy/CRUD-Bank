/*package controller;
//no longer in use
import UML.*;
import Services.*;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.sql.SQLException;

public class transactionController {
    transactionService tServ;
    userService uServ;
    Javalin api;

    public transactionController(transactionService tServ, userService uServ, Javalin api){
        this.tServ = tServ;
        this.uServ = uServ;
        this.api = api;
        api.post("/transactions", this::newTask);
    }

    public void newTask(Context ctx) throws SQLException{
        String authTemp = ctx.cookie("Auth");
        if(authTemp != null){
            User currUser = uServ.readUser(authTemp);
            Transaction t = ctx.bodyAsClass(Transaction.class);
            t.setUser(currUser);
            tServ.addTransac(t);
            ctx.json(t);
            ctx.status(201);
        }
    }
}*/
