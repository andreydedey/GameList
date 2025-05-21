package com.codewithandrey.game.controllers;

import com.codewithandrey.game.dto.GameListDto;
import com.codewithandrey.game.dto.GameMinDTO;
import com.codewithandrey.game.services.GameListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/list")
public class GameListController {
    private final GameListService gameListService;

    @GetMapping()
    public ResponseEntity<Iterable<GameListDto>> findAll() {
        var result = gameListService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}/games")
    public ResponseEntity<Iterable<GameMinDTO>> findAll(
            @PathVariable (name = "id") Long id
    ) {
        var result = gameListService.findByList(id);
        return ResponseEntity.ok(result);
    }

}
