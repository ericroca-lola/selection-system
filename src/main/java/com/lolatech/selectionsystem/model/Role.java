package com.lolatech.selectionsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "role", nullable = false)
    private String role;
}
