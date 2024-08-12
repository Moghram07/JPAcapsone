package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public boolean removeCategory(Integer id) {
        Category category = categoryRepository.getById(id);
        if (category == null) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    public boolean updateCategory(Integer id, Category category) {
        Category c = categoryRepository.getById(id);
        if (c == null) {
            return false;
        }
        c.setCategoryName(category.getCategoryName());

        categoryRepository.save(c);
        return true;
    }
}
