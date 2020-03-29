package yaroslav.service.interfaces;

import yaroslav.model.User;

import java.util.List;

public interface UserService {

    <T> List<T> getAllUsers();

    void deleteUser(Long id);

    boolean addUser(User user);

    void edit(User user);

    User getUser(String username, String password);

    User getUserById(Long id);

    User getUserByUsername(String username);
}
