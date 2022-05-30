package com.example.demo.model.join;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class On {

    @JsonProperty("field")
    String field;

    @JsonProperty("value")
    String value;

}
