package com.example.demo.model;

import com.example.demo.model.criteria.Criteria;
import com.example.demo.model.join.Join;
import com.example.demo.model.target.TargetClause;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

import java.util.List;

@Value
public class Select {

    @JsonProperty(value = "fields", required = true)
    List<TargetClause> fields;

    @JsonProperty(value = "from", required = true)
    List<Table> tables;

    @JsonProperty(value = "joins")
    List<Join> joins;

    @JsonProperty("where")
    Criteria criteria;

}

