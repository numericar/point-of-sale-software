package com.projects.billing.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
	private String categoryId;
	private String name;
	private String description;
	private String bgColor;	
	private String imgUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
