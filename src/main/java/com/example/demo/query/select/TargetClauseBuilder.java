package com.example.demo.query.select;

import com.example.demo.model.target.TargetClause;
import com.example.demo.query.ClauseBuilder;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class TargetClauseBuilder implements ClauseBuilder {

    private final List<TargetClause> targetClauses;

    @Override
    public String build() {
        return targetClauses.stream()
                .map(TargetClause::getQueryView)
                .collect(Collectors.joining(", "));
    }
}
