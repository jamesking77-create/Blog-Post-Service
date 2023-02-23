package util;

import data.model.User;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

    public class Mapper {

        public static User map(RegisterRequest registerRequest) {
            User user = new User();
            user.setUserName(registerRequest.getUsername());
            user.setLastName(registerRequest.getLastName());
            user.setFirstName(registerRequest.getFirstName());
            user.setPassword(registerRequest.getPassword());
            return user;
        }



        public static void map(User foundUser, FindUserResponse response) {
//        User foundUser = userRepository.findById(id);
//        FindUserResponse response = new FindUserResponse();
            response.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
            response.setUserId(foundUser.getId());
            response.setUsername(foundUser.getUserName());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
            response.setDateRegistered(formatter.format(foundUser.getDateRegistered));
        }
    }

