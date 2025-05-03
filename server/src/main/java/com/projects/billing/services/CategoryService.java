package com.projects.billing.services;

import java.util.List;

import com.projects.billing.dtos.CategoryRequest;
import com.projects.billing.dtos.CategoryResponse;

public interface CategoryService {
	CategoryResponse add(CategoryRequest request);
	List<CategoryResponse> getCategories();
}
