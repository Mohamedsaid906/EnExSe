package EnExSe.MicroServiceAuthentification.Service;

import EnExSe.MicroServiceAuthentification.Model.Role;
import EnExSe.MicroServiceAuthentification.Model.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
}
