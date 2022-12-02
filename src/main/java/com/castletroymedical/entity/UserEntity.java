package com.castletroymedical.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String email;

    @Column(nullable = false)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="email", referencedColumnName="email")},
            inverseJoinColumns={@JoinColumn(name="roleID", referencedColumnName="roleId")})
    private List<RoleEntity> roles = new ArrayList<>();
}
