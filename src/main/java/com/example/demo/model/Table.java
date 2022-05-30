package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Table {

    @JsonProperty(value = "table", required = true)
    String tableName;

    @JsonProperty(value = "schema")
    String schemaName;

}
