package com.github.numericguessbackend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {

    private UUID publicId;

    private LocalDateTime createdDate;

    private Boolean closed;
}
