package com.creditboost.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppsStatus {
    WAITING("Ожидание"),
    CONFIRMED("Одобрено"),
    REPAID("Погашен"),
    REJECTED("Отказано");

    private final String name;

}

