package com.github.numericguessbackend.data.entity;

import com.github.numericguessbackend.controller.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "game")
@Getter
@Setter
@NoArgsConstructor
public class Game extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ng_game_id_seq")
    @GenericGenerator(name = "ng_game_id_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "ng_game_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "public_id")
    @NotBlank
    private UUID publicId;

    @Column(name = "number")
    @NotNull
    private Integer number;

    @Column(name = "closed")
    private Boolean closed;
}
