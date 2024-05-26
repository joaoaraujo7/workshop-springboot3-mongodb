package com.tech.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.of("GMT"));
        try {
            return LocalDate.parse(textDate, dtf);
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}
