package com.lolatech.selectionsystem.service;

import com.lolatech.selectionsystem.model.Permission;
import com.lolatech.selectionsystem.model.User;
import com.lolatech.selectionsystem.repository.PermissionRepository;
import com.lolatech.selectionsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private PermissionRepository permissionRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PermissionRepository permissionRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Permission userPermission = permissionRepository.findByPermission("ADMIN");
        user.setPermissions(new HashSet<>(Arrays.asList(userPermission)));
        userRepository.save(user);
    }
}
