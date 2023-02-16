package com.example.start_graphql.api.controller.dto;

import com.example.start_graphql.api.domain.Food;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FoodPayload {

	private final String name;

	public FoodPayload(Food food) {
		this.name = food.getName();
	}
}
