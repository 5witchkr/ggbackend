package com.pickban.ggbackend.recommendpick.domain.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;


    @Column
    private String position;

    @Column
    private String championTier;

    @Column
    private Long opScore;

    @Builder
    public Position(Long id, String position, String championTier, Long opScore) {
        this.Id = id;
        this.position = position;
        this.championTier = championTier;
        this.opScore = opScore;
    }
}
