package com.example.start_graphql.api.controller.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "from")
@ToString
public class FoodInput {

	@NotBlank(message = "이름을 확인해주세요.")
	private String name;
}
