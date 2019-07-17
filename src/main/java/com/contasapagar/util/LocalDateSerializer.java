package com.contasapagar.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateSerializer extends StdSerializer<LocalDate> {
	
	public LocalDateSerializer() {
		super(LocalDate.class);
	}
	
	@Override
	public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		jsonGenerator.writeString(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}
