package com.users.repo.converter;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JsonConverter {

	private Gson gson = new Gson();

	public String toJson(Object obj) {
		return gson.toJson(obj);
	}
}
