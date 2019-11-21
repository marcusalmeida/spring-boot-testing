package com.mvx.springboottesting.integration;

import com.mvx.springboottesting.SpringBootTestingApplication;
import com.mvx.springboottesting.entities.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringBootTestingApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserCaseIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Sql({"classpath:data.sql"})
    @Test
    @Tag("integration")
    void allUsers() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:"+port+"/users", ArrayList.class).size() == 2);
    }
}
