package com.codewithandrey.game.services;

import com.codewithandrey.game.dto.GameDTO;
import com.codewithandrey.game.mappers.GameMapper;
import com.codewithandrey.game.services.exceptions.ResourceNotFoundException;

import com.codewithandrey.game.entities.Game;
import com.codewithandrey.game.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public List<GameDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found. ID: " + id));
        return gameMapper.toDto(game);
    }
}
