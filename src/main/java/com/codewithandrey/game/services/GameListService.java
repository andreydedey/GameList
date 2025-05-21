package com.codewithandrey.game.services;

import com.codewithandrey.game.dto.GameListDto;
import com.codewithandrey.game.mappers.GameListMapper;
import com.codewithandrey.game.repositories.GameListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GameListService {
    private final GameListRepository gameListRepository;
    private final GameListMapper gameListMapper;

    public Iterable<GameListDto> findAll() {
        return gameListRepository.findAll()
                .stream()
                .map(gameListMapper::toDto)
                .toList();
    }
}
