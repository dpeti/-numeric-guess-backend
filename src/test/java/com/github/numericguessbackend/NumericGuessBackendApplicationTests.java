package com.github.numericguessbackend;

import com.github.numericguessbackend.data.mapper.GameMapper;
import com.github.numericguessbackend.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumericGuessBackendApplicationTests {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameMapper gameMapper;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(gameService);
        Assertions.assertNotNull(gameMapper);
    }

}
