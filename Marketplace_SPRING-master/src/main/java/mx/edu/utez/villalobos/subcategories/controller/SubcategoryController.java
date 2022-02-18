package mx.edu.utez.villalobos.subcategories.controller;

import mx.edu.utez.villalobos.categories.controller.CategoryDTO;
import mx.edu.utez.villalobos.categories.controller.CategoryService;
import mx.edu.utez.villalobos.categories.model.Category;
import mx.edu.utez.villalobos.subcategories.model.Subcategory;
import mx.edu.utez.villalobos.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return subcategoryService.findAll();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Message> getById(@PathVariable("id") long id){
        return subcategoryService.findById(id);
    }

    @GetMapping("/category/{id}")
    public  ResponseEntity<Message> getByCategory(@PathVariable("id") long id){
        return subcategoryService.findByCategory(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCategory(@RequestBody SubcategoryDTO subcategoryDTO){
        return subcategoryService.insert(new Subcategory(subcategoryDTO.getDescription(), subcategoryDTO.getStatus(), subcategoryDTO.getCategory()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody SubcategoryDTO subcategoryDTO){
        return subcategoryService.update(new Subcategory(subcategoryDTO.getId(), subcategoryDTO.getDescription(), subcategoryDTO.getStatus(), subcategoryDTO.getCategory()));
    }
}
