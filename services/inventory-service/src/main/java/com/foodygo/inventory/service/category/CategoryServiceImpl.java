package com.foodygo.inventory.service.category;

import com.foodygo.inventory.dto.request.category.CategoryCreateRequest;
import com.foodygo.inventory.dto.request.category.CategoryUpdateRequest;
import com.foodygo.inventory.dto.response.category.CategoryCreateResponse;
import com.foodygo.inventory.dto.response.category.CategoryResponse;
import com.foodygo.inventory.dto.response.category.CategoryUpdateResponse;
import com.foodygo.inventory.entity.Category;
import com.foodygo.inventory.mapper.CategoryMapper;
import com.foodygo.inventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements  CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryCreateResponse createCategory(CategoryCreateRequest request) {
        if(this.categoryRepository.findByName(request.getName()).isPresent()) {
            throw new RuntimeException("Category name already exists!");
        }
        Category category = CategoryMapper.INSTANCE.toCreateEntity(request);

        category = this.categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toCreateResponse(category);
    }

    @Override
    public CategoryUpdateResponse updateCategory(CategoryUpdateRequest request) {
        if(this.categoryRepository.findByName(request.getName()).isPresent()) {
            throw new RuntimeException("Category name already exists!");
        }
        Category category = CategoryMapper.INSTANCE.toUpdateEntity(request);

        category = this.categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toUpdateResponse(category);
    }

    @Override
    public CategoryResponse findCategoryById(int id) {
        return CategoryMapper.INSTANCE.toResponse(this.categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found!")));
    }

    @Override
    public List<CategoryResponse> findAllCategories() {
        return this.categoryRepository.findAll().stream()
                .map(CategoryMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }
}
