package com.example.demo.model.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Objects;

/**
 * @author eaxdev
 */
@Value
public class Field implements TargetClause {

    @JsonProperty(value = "column", required = true)
    String column;

    @JsonProperty(value = "alias")
    String alias;

    @Override
    public String getQueryView() {
        return Objects.isNull(alias) ? column : column + " AS " + alias;
    }

}
