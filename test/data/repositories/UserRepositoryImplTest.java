package data.repositories;

import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    private User user;
    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
        user = new User();
        user.setFirstName("james");
        user.setLastName("king");
        user.setUserName("jamesKing77");
        user.setPassword("0707");
    }
    @Test public void saveOneUser_CountIsOneTest(){
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveOneUser_IdOfUserIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
    }
    @Test public void saveTwoUserWithSameId_counterIsOneTest(){
        userRepository.save(user);
        user.setLastName("kings");
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveOneUser_FindOneUserByIdTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test public void saveTwoUser_findAllUser(){
        userRepository.save(user);
        User newUser = new User();
        userRepository.save(newUser);
        assertEquals(1, user.getId());
        assertEquals(2,newUser.getId());
        userRepository.findAll();
        assertEquals(2, userRepository.findAll().size());
    }


}