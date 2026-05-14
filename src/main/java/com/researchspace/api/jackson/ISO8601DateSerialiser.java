package com.researchspace.api.jackson;

import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serialises a Date to simple ISO date format (yyyy-MM-dd) with no time component.
 * @author rspace
 */
public class ISO8601DateSerialiser extends StdSerializer<Date> {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());

    public ISO8601DateSerialiser() {
        this(null);
    }

    public ISO8601DateSerialiser(Class<Date> t) {
        super(t);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeString(FORMATTER.format(value.toInstant()));
    }

}
