package com.example.demo.query.delete;

import com.example.demo.exception.JsonSQL4JParseException;
import com.example.demo.model.Delete;
import com.example.demo.query.ClauseBuilder;
import com.example.demo.query.Query;
import com.example.demo.query.WhereClauseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeleteQuery implements Query {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Delete delete;

    private final ClauseBuilder whereBuilder;

    public DeleteQuery(String jsonQuery) {
        //validate by schema
        try {
            this.delete = MAPPER.readValue(jsonQuery, Delete.class);
        } catch (JsonProcessingException e) {
            throw new JsonSQL4JParseException("Can not parse json query: [" + jsonQuery + "]", e);
        }
        whereBuilder = new WhereClauseBuilder(delete.getCriteria());
    }

    @Override
    public String getQuery() {
        return "DELETE FROM " + delete.getFromView() + whereBuilder.build();
    }
}
