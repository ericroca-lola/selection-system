package com.lolatech.selectionsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "permission", nullable = false)
    private String permission;
}
