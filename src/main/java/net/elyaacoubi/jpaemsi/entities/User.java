package net.elyaacoubi.jpaemsi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    //index unique pas de duplication
    @Column(name = "USER_NAME", unique = true, length = 20)
    private String username;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    //eager a chaque fois en va telecharger le user on va telechrger automatiquement les roles

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    //new arry list pour eviter null pointer exception
    private List<Role> roles = new ArrayList<>();
}
