package in.genrateBill.BillingSoftware.service;

import in.genrateBill.BillingSoftware.io.CategoryRequest;
import in.genrateBill.BillingSoftware.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
     CategoryResponse add(CategoryRequest request, MultipartFile file);

    List<CategoryResponse> read();

    void delete(String categoryId);
}
