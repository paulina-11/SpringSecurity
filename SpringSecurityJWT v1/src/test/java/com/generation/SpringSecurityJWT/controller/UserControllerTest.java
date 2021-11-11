package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.Post;
import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.PostService;
import com.generation.SpringSecurityJWT.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.AtLeast;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class UserControllerTest {


    @Test
    @DisplayName("Pruebas controller")
    void saveTest(){
        //verificar que el userservice haya sido llamado el metodo save


            UserService userService = mock(UserService.class);
            BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
            UserController userController = new UserController(userService, bCryptPasswordEncoder);

            User user = new User();
            user.setName("Paulina");
            user.setUsername("paulina@hotmail.com");
            user.setPassword("1234");

            when(userService.save(any(User.class))).thenReturn(user);
            User response = userController.saveUser(user);

            verify(userService,times(1)).save (any (User.class));
            verify(bCryptPasswordEncoder, atLeastOnce()). encode("1234");

            assertEquals(user.getName(), response.getName());


    }

    @Test
    @DisplayName("Pruebas controller")
    void saveTest() {

        // Verificar que se haya llamado el servicio
        // Verificar que el servicio nos devuelva un objeto User
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
        UserController userController = new UserController(userService, bCryptPasswordEncoder);

        User user = new User();
        user.setName("Paulina");
        user.setUsername("paulina@hotmail.com");
        user.setPassword("1234");

        when(userService.save(any(User.class))).thenReturn(user);
        User response = userController.saveUser(user);

        verify(userService, times(1)).save(any(User.class));
        verify(bCryptPasswordEncoder, atLeastOnce()).encode("1234");

        assertEquals(user.getName(), response.getName());

    }


    }