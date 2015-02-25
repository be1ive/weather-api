package com.belive.weather.owm.api.impl.json;

import com.belive.weather.owm.api.AbstractPlace;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lena on 25-Feb-15.
 */
class AbstractPlaceDeserializer extends StdDeserializer<AbstractPlace>
{
    private Map<String, Class<? extends AbstractPlace>> registry = new HashMap<>();

    AbstractPlaceDeserializer()
    {
        super(AbstractPlace.class);
    }

    void registerAbstractPlace(String uniqueAttribute,
            Class<? extends AbstractPlace> abstractPlaceClass)
    {
        registry.put(uniqueAttribute, abstractPlaceClass);
    }

    @Override
    public AbstractPlace deserialize(
            JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException
    {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        Class<? extends AbstractPlace> animalClass = null;
        Iterator<Map.Entry<String, JsonNode>> elementsIterator =
                node.fields();
        while (elementsIterator.hasNext())
        {
            Map.Entry<String, JsonNode> element=elementsIterator.next();
            String name = element.getKey();
            if (registry.containsKey(name))
            {
                animalClass = registry.get(name);
                break;
            }
        }
        if (animalClass == null) return null;
        return oc.readValue(jsonParser, animalClass);
    }
}
