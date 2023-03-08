package controllers;

import dtos.Requests.RegisterRequest;
import service.UserService;
import service.UserServiceImpl;

import java.util.NoSuchElementException;

public class UserController {
    private UserService userService = new UserServiceImpl();

     public Object register(RegisterRequest registerRequest){
         try{
             return userService.register(registerRequest);
         }catch (IllegalArgumentException error){
             return error.getMessage();
         }
     }

     public Object findUserById(int id){
         try {
             return userService.findUser(id);
         }catch (NoSuchElementException e){
             return e.getMessage();
         }

     }

     public Object findUserByName(String userName){
         try {
             return userService.findUserByUserName(userName);
         }catch (NoSuchElementException e){
             return e.getMessage();
         }
     }
}
