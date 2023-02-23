package service;

import data.model.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindUserResponse;
import util.Mapper;
import java.time.format.DateTimeFormatter;
import java.util.Map;

    public class UserServiceImpl implements UserService {
        private UserRepository userRepository = new UserRepositoryImpl();

        @Override
        public User register(RegisterRequest registerRequest) {
            if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + "already exists");
            return userRepository.save(Mapper.map(registerRequest));
        }

        @Override
        public User findUser(int id) {
            return null;
        }

        @Override
        public FindUserResponse findUsers(int id) {
            return null;
        }


        private boolean userExist(String username) {
            User foundUser = userRepository.findByUsername(username);
            if (foundUser != null) return true;
            return false;
        }


//        @Override
//        public FindUserResponse findUser(int id) {
//            Mapper.map(id);
//            return response;
//        }
    }

