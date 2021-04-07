package net.codejava;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends CrudRepository<Finance, Integer>{

	public List<Finance> findByCity(String s);

	public Finance findBySerielNumber(int serielNumber);

	@Query("SELECT DISTINCT f.city FROM Finance f")
	public List<String> getCitiesInfo();

	//public List<Finance> findAllByCity();




 
}
