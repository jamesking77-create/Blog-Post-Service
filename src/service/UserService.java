package service;
import data.model.User;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindUserResponse;

import java.util.List;

public interface UserService {
    User register(RegisterRequest registerRequest);
    FindUserResponse findUser(int id);
    String deleteUser(int id);
    FindUserResponse findUserByUserName(String  username);

    //    Object register(RegisterRequest request);
}

