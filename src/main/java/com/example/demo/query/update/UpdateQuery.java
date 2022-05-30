package com.example.demo.query.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.exception.JsonSQL4JParseException;
import com.example.demo.model.Update;
import com.example.demo.query.ClauseBuilder;
import com.example.demo.query.Query;
import com.example.demo.query.WhereClauseBuilder;

import java.util.Objects;
import java.util.stream.Collectors;


public class UpdateQuery implements Query {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Update update;

    private final ClauseBuilder whereBuilder;

    public UpdateQuery(String jsonQuery) {
        //validate by schema
        try {
            this.update = MAPPER.readValue(jsonQuery, Update.class);
        } catch (JsonProcessingException e) {
            throw new JsonSQL4JParseException("Can not parse json query: [" + jsonQuery + "]", e);
        }
        whereBuilder = new WhereClauseBuilder(update.getCriteria());
    }

    @Override
    public String getQuery() {
        return "UPDATE " + update.getTableView() + " SET " + constructUpdate() + whereBuilder.build() + ";";
    }

    private String constructUpdate() {
        return update.getModify().entrySet().stream()
                .map(entry -> {
                    if (entry.getValue() instanceof String) {
                        return entry.getKey() + " = '" + entry.getValue().toString() + "'";
                    } else {
                        return Objects.isNull(entry.getValue()) ? "" : entry.getKey() + " = " + entry.getValue().toString();
                    }
                })
                .collect(Collectors.joining(", "));
    }
}
