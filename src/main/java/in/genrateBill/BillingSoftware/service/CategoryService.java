package in.genrateBill.BillingSoftware.service;

import in.genrateBill.BillingSoftware.io.CategoryRequest;
import in.genrateBill.BillingSoftware.io.CategoryResponse;

import java.util.List;

public interface CategoryService {
     CategoryResponse add(CategoryRequest request);

    List<CategoryResponse> read();
}
