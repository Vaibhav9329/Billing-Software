package in.genrateBill.BillingSoftware.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.genrateBill.BillingSoftware.io.CategoryRequest;
import in.genrateBill.BillingSoftware.io.CategoryResponse;
import in.genrateBill.BillingSoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    //this 1st api endpoint it is for creating the category
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestPart("category") String categoryString,
                                        @RequestPart("file") MultipartFile file){
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryRequest request = null;
        try{
            request = objectMapper.readValue(categoryString,CategoryRequest.class);
            return categoryService.add(request,file);
        }catch (JsonProcessingException ex){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Exception occured while parsing the json: "+ex.getMessage());
        }

    }

    //this 2nd api endpoint  it is for reading the category
    @GetMapping
    public List<CategoryResponse> fetchCategories(){
        return categoryService.read();
    }

    //this 3rd api endpoint it is for deleting the category
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{categoryId}")
    public void remove(@PathVariable String categoryId ){
        try{
            categoryService.delete(categoryId);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}
