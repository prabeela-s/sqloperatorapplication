package com.example.demo.query;

import com.example.demo.TestUtil;
import com.example.demo.exception.JsonSQL4JParseException;
import com.example.demo.query.delete.DeleteQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteTest {

    @Test
    @DisplayName("Should get delete")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("delete/Delete.json");
        System.out.println(json);
        Query deleteQuery = new DeleteQuery(json);
        System.out.println(deleteQuery.getQuery());
        assertEquals("DELETE FROM test", deleteQuery.getQuery());
    }

    @Test
    @DisplayName("Should get delete with schema")
    void shouldGetSelectWithSchema() {
        String json = TestUtil.readFileByPath("delete/DeleteWithSchema.json");
        System.out.println(json);
        Query deleteQuery = new DeleteQuery(json);
        System.out.println(deleteQuery.getQuery());
        assertEquals("DELETE FROM schema.test", deleteQuery.getQuery());
    }

    @Test
    @DisplayName("Should get delete with criteria")
    void shouldGetSelectWithCriteria() {
        String json = TestUtil.readFileByPath("delete/DeleteWithCriteria.json");
        System.out.println(json);
        Query deleteQuery = new DeleteQuery(json);
        System.out.println(deleteQuery.getQuery());
        assertEquals("DELETE FROM schema.test WHERE (field3 = 5 AND field4 = 3)", deleteQuery.getQuery());
    }

    @Test
    @DisplayName("Should get error when json is invalid")
    void shouldGetErrorWhenJsonIsInvalid() {
        JsonSQL4JParseException jsonSQL4JParseException = assertThrows(JsonSQL4JParseException.class,
                () -> new DeleteQuery("{\"invalid:\" \"json\"}"));
        assertEquals("Can not parse json query: [{\"invalid:\" \"json\"}]",
                jsonSQL4JParseException.getMessage());
    }
}
