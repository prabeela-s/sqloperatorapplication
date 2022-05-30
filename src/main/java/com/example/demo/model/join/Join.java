package com.example.demo.model.join;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Join {

    @JsonProperty(value = "type", required = true)
    JoinType joinType;

    @JsonProperty(value = "schema")
    String schemaName;

    @JsonProperty("table")
    String table;

    @JsonProperty("on")
    On on;
}
