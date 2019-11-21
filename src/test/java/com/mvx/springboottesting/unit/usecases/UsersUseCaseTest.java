package com.mvx.springboottesting.unit.usecases;

import com.mvx.springboottesting.entities.User;
import com.mvx.springboottesting.repositories.UserRepository;
import com.mvx.springboottesting.usecases.UsersUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsersUseCaseTest {
    @Mock
    private UserRepository repo;

    @InjectMocks
    private UsersUseCase useCase;

    @Test
    void shouldReturnAllUsers() throws Exception {
        List<User> expectedUsers = Arrays.asList(new User(1L, "Ana"), new User(2L, "Bob"));
        when(repo.findAll()).thenReturn(expectedUsers);
        List<User> users = useCase.findAll();
        Assertions.assertThat(users).containsAll(expectedUsers);
        verify(repo, times(1)).findAll();
    }
}
