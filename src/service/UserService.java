package service;
import data.model.User;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindUserResponse;

public interface UserService {
    User register(RegisterRequest registerRequest);
    User findUser(int id);

    FindUserResponse findUsers(int id);

    //    Object register(RegisterRequest request);
}

