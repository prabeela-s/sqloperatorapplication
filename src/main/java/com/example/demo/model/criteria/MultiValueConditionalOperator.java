package com.example.demo.model.criteria;

import lombok.Getter;


@Getter
public enum MultiValueConditionalOperator {

    IN(" IN ");

    private final String queryView;

    MultiValueConditionalOperator(String queryView) {
        this.queryView = queryView;
    }

}
