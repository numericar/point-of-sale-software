package com.projects.billing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.billing.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
