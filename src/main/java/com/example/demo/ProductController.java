package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	 @Autowired
	    private ProductService productService;

	    @GetMapping
	    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page) {
	        return productService.getProducts(page, 10); // Server-side pagination
	    }

	    @PostMapping
	
	    public Product createProduct(@RequestBody Product product) {
	        return productService.createProduct(product);
	    }

	    @GetMapping("/{id}")
	    public Product getProduct(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        return productService.updateProduct(id, product);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
	
	

}
