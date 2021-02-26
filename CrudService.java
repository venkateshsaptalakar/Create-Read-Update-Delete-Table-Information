package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.CrudRepo;

@Service
public class CrudService {
	
	@Autowired
	private CrudRepo repo;
	
	public List<Product> fetchProductList()
	{
		return repo.findAll();
	}
	
	public Product saveProductToDB(Product product)
	{
		return repo.save(product);
	}

	public Optional<Product> fetchProductById(int id)
	{
		return repo.findById(id);
	}
	

	public String deleteProductById(int id)
	{
		String result;
		try 
		{
			repo.deleteById(id);
			result="product is deleted successfully";
		}
		catch(Exception e){
			result="product is not deleted succesfully";
		}
		 
		return result;
		
	}
}
