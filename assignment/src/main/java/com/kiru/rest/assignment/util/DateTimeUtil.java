package com.kiru.rest.assignment.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

	public static OffsetDateTime convertToDateTime(String stringDateTime) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SXX", Locale.ENGLISH);
		OffsetDateTime date = OffsetDateTime.parse(stringDateTime, inputFormatter);
		return date;
	}


	public static OffsetDateTime getDateTime(Date date) {
		OffsetDateTime offsetDateTime = date.toInstant().atOffset(ZoneOffset.UTC);
		return offsetDateTime;
	}
}
