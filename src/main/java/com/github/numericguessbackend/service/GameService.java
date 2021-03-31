package com.github.numericguessbackend.service;

import com.github.numericguessbackend.data.dto.GameDto;
import com.github.numericguessbackend.data.dto.ResultDto;

import java.util.List;
import java.util.UUID;

public interface GameService {

    List<GameDto> findAllGame();

    GameDto initGame();

    GameDto getOneGame(UUID gameId);

    ResultDto checkNumber(UUID gameId, Integer number);
}
