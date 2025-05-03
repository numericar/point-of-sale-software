package com.projects.billing.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.billing.dtos.CategoryRequest;
import com.projects.billing.dtos.CategoryResponse;
import com.projects.billing.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest requestDto) {
		try {
			CategoryResponse response = this.categoryService.add(requestDto);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryResponse>> getCategories() {
		try {
			List<CategoryResponse> categoryResponses = this.categoryService.getCategories();
			
			return ResponseEntity.status(HttpStatus.OK).body(categoryResponses);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}
