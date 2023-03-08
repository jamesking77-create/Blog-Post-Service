package service;

import data.model.User;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest  {
    private  UserService userService;
    private  RegisterRequest registerRequest;
    private RegisterRequest registerRequest2;

    @BeforeEach public void setUp(){
        userService = new UserServiceImpl();
        registerRequest = new RegisterRequest();
        registerRequest2 = new RegisterRequest();
        registerRequest.setFirstName("james");
        registerRequest.setLastName("king");
        registerRequest.setPassword("0550");
        registerRequest.setUsername("jamesKing");

        registerRequest2.setUsername("9kicks");
        registerRequest2.setPassword("0090");
        registerRequest2.setLastName("han");
        registerRequest2.setFirstName("fola");
    }
    @Test public void registerOneUser_findOneUserTest(){
        User savedUser =  userService.register(registerRequest);
        assertEquals(1, savedUser.getId());
    }
    @Test public void registerOneUser_findUserByUserNameTest(){
       User savedUser =  userService.register(registerRequest);
       assertEquals(savedUser.getUserName(), savedUser.getUserName());
       FindUserResponse foundUser = userService.findUserByUserName(savedUser.getUserName());
       assertEquals(savedUser.getUserName(), foundUser.getUsername());
    }

    @Test public void registerOneUser_deleteUserTest(){
        User savedUser =  userService.register(registerRequest);
        assertEquals(1, savedUser.getId());
        User secondUser = userService.register(registerRequest2);
        assertEquals(2, secondUser.getId());
        String deleteUser =  userService.deleteUser(2);
        assertEquals("User successfully deleted",deleteUser);
    }

    @Test public void registerTwoUser_findUserByIdTest(){
        User savedUser =  userService.register(registerRequest);
        assertEquals(1, savedUser.getId());
        User secondUser = userService.register(registerRequest2);
        assertEquals(2, secondUser.getId());
        FindUserResponse foundUser = userService.findUser(2);
        assertEquals(secondUser.getId(), foundUser.getUserId());
    }

    @Test public void registerTwoUserWithTheSameUsername_ThrowsExceptionTest(){
        userService.register(registerRequest);
        assertThrows(IllegalArgumentException.class, ()-> userService.register(registerRequest));
    }
}