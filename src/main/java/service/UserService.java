package service;

import model.User;

public interface UserService {

    User save(User user);

    void checkForBirthday();
}
