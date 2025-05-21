package com.codewithandrey.game.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;
    private Integer position;

}
