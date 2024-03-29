package com.lolatech.selectionsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Please enter a valid email")
    @NotEmpty(message = "*Please enter an email")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 8, message = "*Password must have at least 8 characters")
    @NotEmpty(message = "*Please enter a password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "active", nullable = false)
    private int active;
}
