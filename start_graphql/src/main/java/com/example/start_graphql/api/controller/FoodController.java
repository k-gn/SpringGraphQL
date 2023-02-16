package com.example.start_graphql.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.start_graphql.api.controller.dto.FoodInput;
import com.example.start_graphql.api.controller.dto.FoodPayload;
import com.example.start_graphql.api.domain.Food;
import com.example.start_graphql.api.service.FoodService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FoodController {

	private final FoodService foodService;

	/**
	 *  @MutationMapping은 @PostMapping과 같은 어노테이션으로 graphql에 Mutation에 사용됩니다.
	 *  graphql은 endpoint과 하나이므로 @MutationMapping 어노테이션만 지정해 주고 다른 설정은 필요 없습니다.
	 */
	@MutationMapping
	public FoodPayload save(@Argument("req") @Valid FoodInput req) {
		return foodService.save(req);
	}

	/**
	 * @QueryMapping도 @GetMapping과 같은 어노테이션 입니다.
	 * 말고도 @SubscriptionMapping이 있습니다.
	 */
	@QueryMapping
	public FoodPayload getFood(@Argument FoodInput req) {
		return foodService.getFood(req);
	}

	@QueryMapping
	public List<FoodPayload> getFoods() {
		return foodService.getFoods();
	}
}
