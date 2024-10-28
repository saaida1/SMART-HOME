package com.SmartHome.SpringProject.repository;

import com.SmartHome.SpringProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
