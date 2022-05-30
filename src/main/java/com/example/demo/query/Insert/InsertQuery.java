package com.example.demo.query.Insert;

import com.example.demo.exception.JsonSQL4JParseException;
import com.example.demo.model.Insert;
import com.example.demo.model.target.TargetClause;
import com.example.demo.model.target.TargetClauseDeserializer;
import com.example.demo.query.Query;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.Objects;
import java.util.stream.Collectors;


public class InsertQuery implements Query {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Insert insert;

    public InsertQuery(String jsonQuery) {
        //validate by schema
        try {
            this.insert = MAPPER.readValue(jsonQuery, Insert.class);
        } catch (JsonProcessingException e) {
            throw new JsonSQL4JParseException("Can not parse json query: [" + jsonQuery + "]", e);
        }
    }

    @Override
    public String getQuery() {
        return "INSERT INTO " + insert.getIntoView() +
                " (" + String.join(", ", insert.getValues().keySet()) + ") " +
                "VALUES (" + constructValues() + ");";
    }

    private String constructValues() {
        return insert.getValues().values().stream()
                .map(o -> {
                    if (o instanceof String) {
                        return "'" + o.toString() + "'";
                    } else {
                        return Objects.isNull(o) ? "" : o.toString();
                    }
                })
                .collect(Collectors.joining(", "));
    }
}
