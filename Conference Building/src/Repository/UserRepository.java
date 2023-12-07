package Repository;

import Models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public User addUser(final String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }
}
