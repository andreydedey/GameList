package com.codewithandrey.game.mappers;

import com.codewithandrey.game.dto.GameListDto;
import com.codewithandrey.game.entities.Game;
import com.codewithandrey.game.entities.GameList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameListMapper {
    GameListDto toDto(GameList gameList);
    GameList toEntity(GameListDto gameListDto);
}
