package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Product;

@Repository
public interface CrudRepo extends JpaRepository<Product,Integer>{

}
