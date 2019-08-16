package com.lolatech.selectionsystem;

import com.lolatech.selectionsystem.model.User;
import com.lolatech.selectionsystem.repository.RoleRepository;
import com.lolatech.selectionsystem.repository.UserRepository;
import com.lolatech.selectionsystem.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private RoleRepository mockRoleRepository;

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceTest;
    private User userTest;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceTest = new UserService(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);
        userTest = User.builder()
                    .id(1L)
                    .email("test@test.com")
                    .password("password")
                    .build();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(userTest);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(userTest);
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run test
        final User result = userServiceTest.findUserByEmail(email);

        // Verify result
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";
        final String password = "password";

        // Run test
        final User result = userServiceTest.saveUser(userTest);

        // Verify result
        assertEquals(email, result.getEmail());
        assertNotEquals(password, result.getPassword());
    }
}
