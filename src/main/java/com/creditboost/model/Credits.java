package com.creditboost.model;

import com.creditboost.model.enums.Goals;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Credits {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private int rate;
    private int minTerm;
    private int maxTerm;
    private int minLimit;
    private int maxLimit;
    @Enumerated(EnumType.STRING)
    private Goals goal;
    private String file;
    @Column(length = 5000)
    private String description;

    public Credits(String name, int rate, int minTerm, int maxTerm, int minLimit, int maxLimit, Goals goal, String file, String description) {
        this.name = name;
        this.rate = rate;
        this.minTerm = minTerm;
        this.maxTerm = maxTerm;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.goal = goal;
        this.file = file;
        this.description = description;
    }
}
