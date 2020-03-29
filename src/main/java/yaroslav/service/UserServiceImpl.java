package yaroslav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import yaroslav.db.dao.UserRepository;
import yaroslav.model.User;
import yaroslav.service.interfaces.UserService;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class UserServiceImpl implements UserService {

    private ExampleMatcher usernameMatcher = ExampleMatcher.matching()
            .withIgnorePaths("id")
            .withMatcher("username", ignoreCase())
            .withIgnorePaths("password")
            .withIgnorePaths("email");

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(getUserById(id));
    }

    @Override
    public boolean addUser(User user) {

        if (userRepository.exists(Example.of(user, usernameMatcher))){
            return false;
        }

        userRepository.saveAndFlush(user);
        return true;
    }

    @Override
    public void edit(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean userIsExist(User user) {
        return userRepository.exists(Example.of(user, usernameMatcher));
    }
}
