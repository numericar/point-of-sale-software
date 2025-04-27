package com.projects.billing.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.billing.dtos.CategoryRequest;
import com.projects.billing.dtos.CategoryResponse;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@PostMapping
	public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest requestDto) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
