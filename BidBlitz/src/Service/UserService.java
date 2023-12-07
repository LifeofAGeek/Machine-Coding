package Service;

import models.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(final User user) {
        userRepository.addUser(user);
        System.out.println(user.getName() + " added successfully");
    }
}
