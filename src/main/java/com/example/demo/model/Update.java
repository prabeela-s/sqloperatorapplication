package com.example.demo.model;


import com.example.demo.model.criteria.Criteria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Map;
import java.util.Objects;

@Value
public class Update {

    @JsonProperty(value = "table", required = true)
    Table table;

    @JsonProperty(value = "modify", required = true)
    Map<String, Object> modify;

    @JsonProperty("where")
    Criteria criteria;

    public String getTableView() {
        return (Objects.isNull(table.getSchemaName()) || table.getSchemaName().isEmpty())
                ? table.getTableName() : table.getSchemaName() + "." + table.getTableName();
    }

}
