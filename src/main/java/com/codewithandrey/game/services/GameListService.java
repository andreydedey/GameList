package com.codewithandrey.game.services;

import com.codewithandrey.game.dto.GameDTO;
import com.codewithandrey.game.dto.GameListDto;
import com.codewithandrey.game.dto.GameMinDTO;
import com.codewithandrey.game.mappers.GameListMapper;
import com.codewithandrey.game.repositories.GameListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GameListService {
    private final GameListRepository gameListRepository;
    private final GameListMapper gameListMapper;

    @Transactional(readOnly = true)
    public Iterable<GameListDto> findAll() {
        return gameListRepository.findAll()
                .stream()
                .map(gameListMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Iterable<GameMinDTO> findByList(Long listId) {
        var result = gameListRepository.searchByList(listId);
        return result;
    }
}
