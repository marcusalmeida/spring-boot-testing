package com.mvx.springboottesting.unit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvx.springboottesting.controllers.UsersController;
import com.mvx.springboottesting.entities.User;
import com.mvx.springboottesting.usecases.UsersUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UsersController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsersUseCase useCase;

    @Test
    void shouldReturnAllUsers() throws Exception {
        User ana = new User(1L, "Ana");
        User bob = new User(2L, "Bob");
        List<User> users = Arrays.asList(ana, bob);
        when(useCase.findAll()).thenReturn(users);

        mockMvc.perform(get("/users")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(status().isOk());

        verify(useCase, times(1)).findAll();
    }
}
