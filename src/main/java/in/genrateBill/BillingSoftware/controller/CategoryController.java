package in.genrateBill.BillingSoftware.controller;


import in.genrateBill.BillingSoftware.io.CategoryRequest;
import in.genrateBill.BillingSoftware.io.CategoryResponse;
import in.genrateBill.BillingSoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
           return categoryService.add(request);
    }
}
