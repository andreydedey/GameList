package com.codewithandrey.game.controllers;

import com.codewithandrey.game.dto.GameDTO;
import com.codewithandrey.game.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        var result = gameService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> findGame(
            @PathVariable(name = "id") Long id
    ) {
        var result = gameService.findById(id);
        return ResponseEntity.ok(result);
    }
}
