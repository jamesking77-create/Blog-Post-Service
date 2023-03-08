package service;

import data.model.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindUserResponse;
import util.Mapper;

import java.util.NoSuchElementException;


public class UserServiceImpl implements UserService {
        private final UserRepository userRepository = new UserRepositoryImpl();

        @Override
        public User register(RegisterRequest registerRequest) {
            if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + " already exists");
            return userRepository.save(Mapper.map(registerRequest));
        }

        @Override
        public FindUserResponse findUser(int id) {
            FindUserResponse userResponse = new FindUserResponse();
            User foundUser = userRepository.findById(id);
            if (foundUser == null) throw new NoSuchElementException("user doesn't exist");
            Mapper.map(foundUser, userResponse);
            return userResponse;
        }



        @Override
        public String deleteUser(int id) {
            if (id == userRepository.findById(id).getId()) {
                userRepository.deleteById(id);
                return "User successfully deleted";
            }
            return null;
        }


        @Override
        public FindUserResponse findUserByUserName(String userName) {
            FindUserResponse userResponse = new FindUserResponse();
            User foundUser = userRepository.findByUsername(userName);
            if (foundUser == null) throw new NoSuchElementException("user doesn't exist");
            Mapper.map(foundUser, userResponse);
            return userResponse;
        }


        private  boolean userExist(String username) {
            User foundUser = userRepository.findByUsername(username);
            return foundUser != null;
        }


    }

