package com.lolatech.selectionsystem.repository;

import com.lolatech.selectionsystem.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByPermission(String permission);
}
