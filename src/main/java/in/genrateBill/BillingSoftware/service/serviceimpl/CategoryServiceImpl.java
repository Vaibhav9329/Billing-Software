package in.genrateBill.BillingSoftware.service.serviceimpl;

import in.genrateBill.BillingSoftware.entity.CategoryEntity;
import in.genrateBill.BillingSoftware.io.CategoryRequest;
import in.genrateBill.BillingSoftware.io.CategoryResponse;
import in.genrateBill.BillingSoftware.repository.CategoryRepository;
import in.genrateBill.BillingSoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryResponse add(CategoryRequest request) {
        CategoryEntity newCat = convertToEntity(request);
         newCat = categoryRepository.save(newCat);
            return   convertToResponse(newCat);

    }

    @Override
    public List<CategoryResponse> read() {
      return categoryRepository.findAll()
              .stream()
              .map(categoryEntity -> convertToResponse(categoryEntity))
              .collect(Collectors.toList());

    }

    private CategoryResponse convertToResponse(CategoryEntity newCat) {
       return CategoryResponse.builder()
                .categoryId(newCat.getCategoryId())
                .name(newCat.getName())
                .description(newCat.getDescription())
                .bgColor(newCat.getBgColor())
                .imgUrl(newCat.getImgUrl())
                .createdAt(newCat.getCreatedAt())
                .updatedAt(newCat.getUpdatedAt())
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
}
