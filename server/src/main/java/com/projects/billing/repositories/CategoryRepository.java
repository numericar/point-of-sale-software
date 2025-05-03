package com.projects.billing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projects.billing.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Modifying
	@Query("DELETE FROM Category c WHERE c.categoryId = :categoryId")
	void deleteByCategoryId(@Param("categoryId") String categoryId);
}
