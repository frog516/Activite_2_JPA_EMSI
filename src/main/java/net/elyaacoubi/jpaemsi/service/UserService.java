package net.elyaacoubi.jpaemsi.service;

import net.elyaacoubi.jpaemsi.entities.Role;
import net.elyaacoubi.jpaemsi.entities.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String UserName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);

    User authenticate(String userName, String password);
}
