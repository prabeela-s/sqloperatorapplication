package com.example.demo.model.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * @author eaxdev
 */
@Value
public class Expression implements TargetClause {

    @JsonProperty("expression")
    String expression;

    @Override
    public String getQueryView() {
        return expression;
    }
}
