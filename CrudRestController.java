package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.service.CrudService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CrudRestController {
	
	@Autowired
	private CrudService service;
	@GetMapping(path = "/getproductlist")
	public List<Product> fetchProductList()
	{
		List<Product> products=new ArrayList<Product>();
		//logic to fetch data from database
		products=service.fetchProductList();
		return products;
	}
	
	@PostMapping(path = "/addproduct")
	public Product saveProduct(@RequestBody Product product)
	{
		
		return service.saveProductToDB(product);
	}
	
	@GetMapping(path = "/getproductbyid/{id}")
	public Product fetchProductById(@PathVariable int id)
	{
		return service.fetchProductById(id).get();
	}
	
	@DeleteMapping(path = "/deleteproductbyid/{id}")
	public String deleteProductById(@PathVariable int id)
	{
		
		return service.deleteProductById(id);
	}

}
