package com.codewithandrey.game.mappers;

import com.codewithandrey.game.dto.GameDTO;
import com.codewithandrey.game.entities.Game;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO toDto(Game game);
}
