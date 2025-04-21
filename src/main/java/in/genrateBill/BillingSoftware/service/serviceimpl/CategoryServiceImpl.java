package in.genrateBill.BillingSoftware.service.serviceimpl;

import in.genrateBill.BillingSoftware.entity.CategoryEntity;
import in.genrateBill.BillingSoftware.io.CategoryRequest;
import in.genrateBill.BillingSoftware.io.CategoryResponse;
import in.genrateBill.BillingSoftware.repository.CategoryRepository;
import in.genrateBill.BillingSoftware.service.CategoryService;
import in.genrateBill.BillingSoftware.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final FileUploadService fileUploadService;

    @Override
    public CategoryResponse add(CategoryRequest request, MultipartFile file) {

        String imgUrl = fileUploadService.uploadFile(file);
        CategoryEntity newCat = convertToEntity(request);
        newCat.setImgUrl(imgUrl);
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

    @Override
    public void delete(String categoryId) {
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
                .orElseThrow(()->new RuntimeException("Category Not Found: "+categoryId ));
            fileUploadService.deleteFile(existingCategory.getImgUrl());
        categoryRepository.delete(existingCategory);
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
