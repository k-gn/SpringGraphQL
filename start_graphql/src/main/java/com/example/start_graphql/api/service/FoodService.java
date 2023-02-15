package com.example.start_graphql.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.start_graphql.api.domain.Food;
import com.example.start_graphql.api.domain.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodService {

	private final FoodRepository foodRepository;

	@Transactional
	public Food save(String name) {
		return foodRepository.save(Food.from(name));
	}

	public Food getFood(String name) {
		return foodRepository.findByName(name).orElseThrow(EntityNotFoundException::new);
	}

	public List<Food> getFoods() {
		return foodRepository.findAll();
	}
}
