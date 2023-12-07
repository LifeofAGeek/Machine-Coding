package repository;

import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    final Map<String, User> users = new HashMap<>();

    // add user
    public void addUser(final User user) {
        users.put(user.getId(), user);
    }
}
