package com.github.numericguessbackend.data.mapper;

import com.github.numericguessbackend.data.dto.GameDto;
import com.github.numericguessbackend.data.entity.Game;
import org.mapstruct.Mapper;

@Mapper
public interface GameMapper extends EntityMapper<GameDto, Game> {
}
