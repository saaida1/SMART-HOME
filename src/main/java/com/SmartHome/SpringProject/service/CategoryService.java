package com.SmartHome.SpringProject.service;


import com.SmartHome.SpringProject.model.Category;
import com.SmartHome.SpringProject.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Autowired
    private final CategoryRepo categoryRepo;



    //list all categories
    public List<Category> listAllCategories(){
        return categoryRepo.findAll();
    }

    //find a category by id
    public Optional<Category> getById(Long id){
        return categoryRepo.findById(id);
    }

    //delete Category

    public void deleteCategoryById(Long id){
        categoryRepo.deleteById(id);

    }

    //save a Category
    public Category saveCategory(Category category){
        return categoryRepo.save(category);
    }

    //Update

    public Category updateCategory(Category category, Long id){
        if(categoryRepo.existsById(id)){
            category.setId(id);
            return categoryRepo.save(category);
        }
        return null;
    }
}
