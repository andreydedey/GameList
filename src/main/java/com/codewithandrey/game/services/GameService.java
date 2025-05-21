package com.codewithandrey.game.services;

import com.codewithandrey.game.entities.Game;
import com.codewithandrey.game.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
