package com.example.demo.model.join;

import lombok.Getter;


@Getter
public enum JoinType {

    INNER(" INNER JOIN "),

    RIGHT(" RIGHT JOIN "),

    LEFT(" LEFT JOIN ");

    private final String queryView;

    JoinType(String queryView) {
        this.queryView = queryView;
    }
}
