package net.elyaacoubi.jpaemsi.repositories;

import net.elyaacoubi.jpaemsi.entities.Role;
import net.elyaacoubi.jpaemsi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
