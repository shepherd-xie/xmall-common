package com.orkva.xmall.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import java.io.IOException;
import java.time.Instant;

/**
 * CustomInstantModule
 *
 * @author Shepherd Xie
 * @version 2023/8/15
 */
@ConditionalOnMissingBean
public class CustomInstantModule extends SimpleModule {
    private static final JsonSerializer<Instant> INSTANT_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.getEpochSecond());
        }
    };

    public CustomInstantModule() {
        addSerializer(Instant.class, INSTANT_SERIALIZER);
    }
}
