package com.pickban.ggbackend.recommendpick.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private Long championId;

    @Column
    private String championName;

    @Column
    private String position;

    @Column
    private String championTier;

    @Column
    private Long opScore;

    @ElementCollection
    private List<Long> counters;

    @Builder
    public Champion(Long championId, String championName, String position, String championTier, Long opScore, List<Long> counters) {
        this.championId = championId;
        this.championName = championName;
        this.position = position;
        this.championTier = championTier;
        this.opScore = opScore;
        this.counters = counters;
    }

}
