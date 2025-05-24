package com.codewithandrey.game.services;

import com.codewithandrey.game.dto.GameListDto;
import com.codewithandrey.game.dto.GameMinDTO;
import com.codewithandrey.game.mappers.GameListMapper;
import com.codewithandrey.game.repositories.GameListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class GameListService {
    private final GameListRepository gameListRepository;
    private final GameListMapper gameListMapper;
    private final GameService gameService;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return gameListRepository.findAll()
                .stream()
                .map(gameListMapper::toDto)
                .toList();
    }


    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameListRepository.searchByList(listId);
    }

    @Transactional(readOnly = false)
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinDTO> gameList = this.findByList(listId);

        GameMinDTO gameToMove = gameList.remove(sourceIndex);
        gameList.add(destinationIndex, gameToMove);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            GameMinDTO game = gameList.get(i);
            gameListRepository.updateBelongingPosition(listId, game.getId(), i);
        }
    }
}
