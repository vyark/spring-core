package com.epam.service;

import com.epam.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {
    @Autowired
    private UserService service = new UserService();

    @Test
    public void shouldGetUserById() {
        User result = service.getUserById(1);

        assertEquals(1, result.getId());
    }

    @Test
    public void shouldGetUserByEmail_success() {
        User result = service.getUserByEmail("olga@mail.com");

        assertEquals("olga@mail.com", result.getEmail());
    }

    @Test
    public void shouldGetUserByEmail_throwException() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () ->
                service.getUserByEmail("tom@mail.com"));

        assertEquals("User does not exist with email: tom@mail.com", thrown.getMessage());

    }

    @Test
    public void shouldGetUsersByName() {
        List<User> result = service.getUsersByName("John", 5, 1);

        assertEquals(1, result.size());
    }

    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setId(3);
        user.setName("Alice");
        user.setEmail("alice@mail.com");

        User result = service.createUser(user);

        assertEquals(3, result.getId());
    }

    @Test
    public void shouldUpdateUser() {
        User user = new User();
        user.setId(2);
        user.setName("Peter");
        user.setEmail("peter@mail.com");

        User result = service.updateUser(user);

        assertEquals("Peter", result.getName());
        assertEquals("peter@mail.com", result.getEmail());
    }

    @Test
    public void shouldDeleteUser_success() {
        boolean result = service.deleteUser(2);

        assertEquals(true, result);
    }

    @Test
    public void shouldDeleteUser_throwException() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () ->
                service.deleteUser(3));

        Assertions.assertEquals("User doesn't exist with id: 3", thrown.getMessage());
    }
}
