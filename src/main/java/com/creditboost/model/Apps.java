package com.creditboost.model;

import com.creditboost.model.enums.AppsStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Apps {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Credits credit;
    @ManyToOne(fetch = FetchType.LAZY)
    private Users owner;
    @Enumerated(EnumType.STRING)
    private AppsStatus status;
    @Column(length = 5000)
    private String reason;
    private int sum;
    private int term;
    private int should;

    public Apps(Credits credit, Users owner, int sum, int term) {
        this.credit = credit;
        this.owner = owner;
        this.sum = sum;
        this.term = term;
        status = AppsStatus.WAITING;
        reason = "";
        should = ((sum / credit.getRate()) * term) + sum;
    }
}
