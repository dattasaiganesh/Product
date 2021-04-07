package net.codejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FinanceService {
	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("finance.xml");
	//EntityManager em = emf.createEntityManager();
	
	@Autowired
	private FinanceRepository repo;
	
	public List<Finance> listAll() {
		System.out.println("in listAll service method");
		return (List<Finance>) repo.findAll();
	}
	
	public void save(Finance product) {
		System.out.println("in save service method");
		repo.save(product);
	}
	
	public Finance get(int serielNumber) {
	 // return repo.findById(serielNumber);
	  return repo.findBySerielNumber(serielNumber);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
		//repo.deleteById(id);
	}

	public List<Finance> getCitywise(String s) {
		// (Finance) repo.findAll();
		//return null;
		// TODO Auto-generated method stub
	//	List<Finance> finance = new ArrayList<Finance>();
		// return em.find(Finance.class, city);
		return repo.findByCity(s);
		
	//	@Query("select * from public.financetable p where p.city ='city'")
		//List<Long> getExistenIds(List<> ids);
		//return (List<Finance>) repo.find;
	  /*  List<Finance> product = repo.findAll();
	    product.stream().filter(city->city).collect(Collector.toList());
		repo.findAll(city);
*/		
	}

	public Finance getCustomerwise(int serielNumber) {
		
		Finance finance = repo.findBySerielNumber(serielNumber);
		System.out.println("in getCustomerWise service method");
		return finance;
	}

	public List<String> getCitywiseInfo() {
		// TODO Auto-generated method stub
		
		//List<Finance> finances = repo.getCitiesInfo();

		List<String> finances = repo.getCitiesInfo();
		
		System.out.println("after  getCityWise service method");
		//System.out.println("city name first one" +finances.getCity());
		return finances;
	}

}
