package net.elyaacoubi.jpaemsi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.elyaacoubi.jpaemsi.entities.Role;
import net.elyaacoubi.jpaemsi.entities.User;
import net.elyaacoubi.jpaemsi.repositories.RoleRepository;
import net.elyaacoubi.jpaemsi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

   // public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
      //  this.userRepository = userRepository;
    //    this.roleRepository = roleRepository;
    //}

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String userName) {

        return userRepository.findUserByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null) {

            user.getRoles().add(role);
            role.getUsers().add(user);
            //pas besoin parceque la methode est transactionnel
            //userRepository.save(user);
        }


    }

    @Override
    public User authenticate(String userName, String password) {

        User user = userRepository.findUserByUsername(userName);
        if(user==null)      throw new RuntimeException("bad credentials!");

        if(user.getPassword().equals(password)) {
            return user;

    }
     throw new RuntimeException("bad credentials!");
}
}