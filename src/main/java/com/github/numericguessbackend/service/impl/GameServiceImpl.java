package com.github.numericguessbackend.service.impl;

import com.github.numericguessbackend.data.Result;
import com.github.numericguessbackend.data.dto.GameDto;
import com.github.numericguessbackend.data.dto.ResultDto;
import com.github.numericguessbackend.data.entity.Game;
import com.github.numericguessbackend.data.mapper.GameMapper;
import com.github.numericguessbackend.data.repository.GameRepository;
import com.github.numericguessbackend.service.GameService;
import com.github.numericguessbackend.service.error.GameClosedError;
import com.github.numericguessbackend.service.error.GameNotFoundError;
import com.github.numericguessbackend.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Game service implementation
 */
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final GameMapper gameMapper;

    /**
     * Get all games from database
     *
     * @return all Game record
     */
    @Override
    public List<GameDto> findAllGame() {
        return gameMapper.toDto(gameRepository.findAll());
    }

    /**
     * New game initialization
     *
     * @return new GameDto
     */
    @Override
    public GameDto initGame() {
        Game e = new Game();
        e.setPublicId(UUID.randomUUID());
        e.setNumber(RandomUtil.getRandom());
        return gameMapper.toDto(gameRepository.save(e));
    }

    /**
     * Get a Game by public Id
     *
     * @param gameId
     * @return GameDto
     */
    @Override
    public GameDto getOneGame(UUID gameId) {
        Game game = gameRepository.findGameByPublicId(gameId)
                .orElseThrow(() -> new GameNotFoundError("Game not found with public id: " + gameId));
        return gameMapper.toDto(game);
    }

    /**
     * Check a number
     *
     * @param gameId
     * @param number
     * @return ResultDto
     */
    @Override
    @Transactional
    public ResultDto checkNumber(UUID gameId, Integer number) {
        Game game = gameRepository.findGameByPublicId(gameId)
                .orElseThrow(() -> new GameNotFoundError("Game not found with public id: " + gameId));
        if (game.getClosed() != null && game.getClosed()) {
            throw new GameClosedError("Game is closed with id: " + gameId);
        }
        return getResult(game, number);
    }

    private ResultDto getResult(Game game, Integer number) {
        ResultDto result = new ResultDto();
        if (game.getNumber() > number) {
            result.setResult(Result.LOWER);
        } else if (game.getNumber() < number) {
            result.setResult(Result.UPPER);
        } else if (game.getNumber().equals(number)) {
            game.setClosed(Boolean.TRUE);
            result.setResult(Result.EQUAL);
        }
        return result;
    }
}
