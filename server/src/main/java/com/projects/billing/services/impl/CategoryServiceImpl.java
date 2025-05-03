package com.projects.billing.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.billing.dtos.CategoryRequest;
import com.projects.billing.dtos.CategoryResponse;
import com.projects.billing.entities.Category;
import com.projects.billing.repositories.CategoryRepository;
import com.projects.billing.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	@Transactional
	@Override
	public CategoryResponse add(CategoryRequest request) {
		Category entity = convertToEntity(request);
		
		final String categoryId = UUID.randomUUID().toString().replace("-", "");
		entity.setCategoryId(categoryId);
		
		Category newCategory = this.categoryRepository.save(entity);
		
		return this.convertToResponse(newCategory);
	}

	private Category convertToEntity(CategoryRequest request) {
		return Category
				.builder()
				.name(request.getName())
				.description(request.getDescription())
				.bgColor(request.getBgColor())
				.build();
	}
	
	private CategoryResponse convertToResponse(Category entity) {
		return CategoryResponse
				.builder()
				.categoryId(entity.getCategoryId())
				.name(entity.getName())
				.description(entity.getDescription())
				.bgColor(entity.getBgColor())
				.imgUrl(entity.getImgUrl())
				.createdAt(entity.getCreatedAt())
				.updatedAt(entity.getUpdatedAt())
				.build();
	}

	@Override
	public List<CategoryResponse> getCategories() {
		List<Category> categories = this.categoryRepository.findAll();
		
		List<CategoryResponse> categoryResponses = new ArrayList<>();
		
		for (Category category : categories) {
			CategoryResponse categoryResponse = this.convertToResponse(category);
			categoryResponses.add(categoryResponse);
		}
		
		return categoryResponses;
	}

	@Transactional
	@Override
	public void delete(String categoryId) {
		this.categoryRepository.deleteByCategoryId(categoryId);
	}

}
