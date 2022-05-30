package com.example.demo.model;

import com.example.demo.model.criteria.Criteria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Objects;

@Value
public class Delete {

    @JsonProperty(value = "schema")
    String schema;

    @JsonProperty(value = "table", required = true)
    String table;

    @JsonProperty("where")
    Criteria criteria;

    public String getFromView() {
        return Objects.isNull(schema) || schema.isEmpty() ? table : schema + "." + table;
    }

}
