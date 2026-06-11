package com.researchspace.api.jackson;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serialises a {@link Date} to ISO date format {@code yyyy-MM-dd} with no time component.
 * <p>
 * Dates are always serialised in UTC. A {@code Date} value is converted to its UTC calendar
 * date before formatting, so callers must ensure the logical date they intend to send matches
 * the UTC date of the {@code Date} instance (e.g. set to midnight UTC).
 * </p>
 */
public class ISO8601DateSerialiser extends StdSerializer<Date> {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);

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
