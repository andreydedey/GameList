package com.codewithandrey.game.controllers;

import com.codewithandrey.game.dto.GameMinDTO;
import com.codewithandrey.game.mappers.GameMapper;
import com.codewithandrey.game.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final GameMapper gameMapper;

    @GetMapping
    public List<GameMinDTO> findAll() {
        var result = gameService.findAll();
        return result.stream()
                .map(gameMapper::toDto)
                .toList();
    }
}
