package com.pickban.ggbackend.recommendpick.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private Long champId;

    @Column
    private String champName;

    @Column
    private String position;

    @Column
    private String champTier;

    @Column
    private Long champOpScore;

    @ElementCollection
    private List<Long> champCounterList;

    public Champion(Long champId, String champName, String position, String champTier, Long champOpScore, List<Long> champCounterList) {
        this.champId = champId;
        this.champName = champName;
        this.position = position;
        this.champTier = champTier;
        this.champOpScore = champOpScore;
        this.champCounterList = champCounterList;
    }
}
