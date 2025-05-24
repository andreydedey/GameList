package com.codewithandrey.game.dto;

import lombok.Data;

@Data
public class ReplaceGameRequest {
    private Integer sourceIndex;
    private Integer destinationIndex;
}
