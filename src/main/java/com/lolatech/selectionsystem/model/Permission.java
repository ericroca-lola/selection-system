package com.lolatech.selectionsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permission")
class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id", unique = true, nullable = false)
    private int id;

    @Column(name = "permission", nullable = false)
    private String permission;
}
