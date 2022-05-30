package com.example.demo.query;

import com.example.demo.TestUtil;
import com.example.demo.query.update.UpdateQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author eaxdev
 */
class UpdateTest {

    @Test
    @DisplayName("Should get update")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("update/Update.json");
        Query updateQuery = new UpdateQuery(json);
        assertEquals("UPDATE security.audit " +
                "SET eventType = 'MODIFY', eventDate = '2020-01-01T23:28:56.782Z', userId = 100 " +
                "WHERE id = 5;", updateQuery.getQuery());
    }

}
