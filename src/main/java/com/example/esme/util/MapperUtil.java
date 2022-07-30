package com.example.esme.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class MapperUtil {

	private ObjectMapper objectMapper;

	public MapperUtil() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// solution to: com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
		// No serializer found for class
		this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		this.objectMapper.registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
				false);
	}

	public <T> T mapperObject(Object imput, Class<T> output) {
		return this.objectMapper.convertValue(imput, output);
	}

}
