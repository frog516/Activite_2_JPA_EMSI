package net.elyaacoubi.jpaemsi.repositories;

import net.elyaacoubi.jpaemsi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
