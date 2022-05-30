package com.example.demo.query;


import com.example.demo.TestUtil;
import com.example.demo.query.Insert.InsertQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertTest {

    @Test
    @DisplayName("Should get insert")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("insert/Insert.json");
        Query insertQuery = new InsertQuery(json);
        System.out.println(insertQuery.getQuery());
        assertEquals("INSERT INTO PAYMENTS_DEV.audit (eventType, eventDate, userId) " +
                "VALUES ('UPDATED_DATE', '2020-01-01T23:28:56.782Z', 100);", insertQuery.getQuery());
    }

}
