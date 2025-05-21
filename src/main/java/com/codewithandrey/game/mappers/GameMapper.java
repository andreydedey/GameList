package com.codewithandrey.game.mappers;

import com.codewithandrey.game.entities.Game;
import com.codewithandrey.game.dto.GameMinDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameMinDTO toDto(Game game);
}
