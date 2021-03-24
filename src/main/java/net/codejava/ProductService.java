package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		System.out.println("in listAll service method");
		return repo.findAll();
	}
	
	public void save(Product product) {
		System.out.println("in save service method");
		repo.save(product);
	}
	
	public Product get(long id) {
	  return	repo.findOne(id);
	}
	
	public void delete(long id) {
		repo.delete(id);
		//repo.deleteById(id);
	}
}
