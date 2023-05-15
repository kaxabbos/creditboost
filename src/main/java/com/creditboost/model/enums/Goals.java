package com.creditboost.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Goals {
    PARTNER_PROGRAMS("В рамках партнерских программ"),
    CONSUMER_NEEDS("На потребительские нужды"),
    FINANCIAL_PROPERTIES("На финансовые недвижимости");

    private final String name;

}

