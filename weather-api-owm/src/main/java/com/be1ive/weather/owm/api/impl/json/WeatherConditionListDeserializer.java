package com.be1ive.weather.owm.api.impl.json;

import com.be1ive.weather.owm.api.WeatherCondition;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class WeatherConditionListDeserializer extends JsonDeserializer<List<WeatherCondition>> {

    @Override
    public List<WeatherCondition> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        try {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            if (node != null) {
                List<WeatherCondition> list = new ArrayList<>();
                for (Iterator<JsonNode> itr = node.elements(); itr.hasNext(); ) {
                    list.add(WeatherCondition.forId(itr.next().get("id").asText()));
                }
                return list;
            } else {
                return Collections.EMPTY_LIST;
            }
        } catch (IllegalArgumentException e) {
            return Collections.EMPTY_LIST;
        }
    }
}
