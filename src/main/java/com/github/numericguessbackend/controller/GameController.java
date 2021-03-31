package com.github.numericguessbackend.controller;

import com.github.numericguessbackend.data.dto.GameDto;
import com.github.numericguessbackend.data.dto.ResultDto;
import com.github.numericguessbackend.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/games")
@RestController
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDto>> getGameList() {
        log.info("GameController.getGameList() called");
        return ResponseEntity.ok(gameService.findAllGame());
    }

    @GetMapping("/init")
    public ResponseEntity<GameDto> initGame() {
        log.info("GameController.initGame() called");
        return ResponseEntity.ok(gameService.initGame());
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<GameDto> getOneGame(@PathVariable UUID publicId) {
        log.info("GameController.getOneGame() called");
        return ResponseEntity.ok(gameService.getOneGame(publicId));
    }

    @GetMapping("/{publicId}/check/{number}")
    public ResponseEntity<ResultDto> checkNumber(@PathVariable UUID publicId, @PathVariable Integer number) {
        log.info("GameController.checkNumber() called");
        return ResponseEntity.ok(gameService.checkNumber(publicId, number));
    }
}
