package com.example.start_graphql.api.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.start_graphql.api.controller.dto.FoodInput;
import com.example.start_graphql.api.controller.dto.FoodPayload;
import com.example.start_graphql.api.domain.Food;
import com.example.start_graphql.api.domain.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodService {

	private final FoodRepository foodRepository;

	@Transactional
	public FoodPayload save(FoodInput req) {
		return new FoodPayload(foodRepository.save(Food.from(req.getName())));
	}

	public FoodPayload getFood(FoodInput req) {
		return new FoodPayload(foodRepository.findByName(req.getName())
			.orElseThrow(EntityNotFoundException::new));
	}

	public List<FoodPayload> getFoods() {
		return foodRepository.findAll().stream()
			.map(FoodPayload::new)
			.collect(Collectors.toList());
	}
}
