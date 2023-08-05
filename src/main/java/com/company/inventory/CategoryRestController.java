package com.company.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
		@Autowired
		private ICategoryService service;
		
		@GetMapping("/categories")
		public ResponseEntity<CategoryResponseRest> searchCategories(){
			
		ResponseEntity<CategoryResponseRest> response = service.search();
		return response;
		}
		
		@GetMapping("/categories/{id}")
		public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){
			
		ResponseEntity<CategoryResponseRest> response = service.searchById(id);
		return response;
		}
		
		@PostMapping("/categories")
		public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){
			
			ResponseEntity<CategoryResponseRest> response = service.save(category);
			return response;
		}
		
		@PutMapping("/categories/{id}")
		public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id){
			
			ResponseEntity<CategoryResponseRest> response = service.update(category, id);
			return response;
		}
		
		@DeleteMapping("/categories/{id}")
		public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id){
			
			ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
			return response;
		}
		
} 
