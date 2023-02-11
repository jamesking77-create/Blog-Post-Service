package data.repositories;

import data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int count;
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        boolean userHaveNotBeenSaved = user.getId() == 0;
        if (userHaveNotBeenSaved) {
            user.setId(generateId());
            users.add(user);
            count++;
        }
        return user;
    }

    private void saveNewUser(User user) {
        user.setId(generateId());
        count++;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public User findById(int id) {
        for (User user : users ) {
            if (user.getId()==id)
                return user;
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
            return users;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
