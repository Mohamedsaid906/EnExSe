package EnExSe.MicroServiceAuthentification.Service.Impl;

import EnExSe.MicroServiceAuthentification.Model.Role;
import EnExSe.MicroServiceAuthentification.Model.User;
import EnExSe.MicroServiceAuthentification.Repository.RoleRepository;
import EnExSe.MicroServiceAuthentification.Repository.UserRepository;
import EnExSe.MicroServiceAuthentification.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


   private final UserRepository userRep;
    private final RoleRepository roleRep;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRep, RoleRepository roleRep, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRep = userRep;
        this.roleRep = roleRep;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);    }

    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRep.findByUsername(username);
        Role r = roleRep.findByRole(rolename);
        usr.getRoles().add(r);
        return usr;    }
}
