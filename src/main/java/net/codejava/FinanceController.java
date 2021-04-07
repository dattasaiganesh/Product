package net.codejava;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FinanceController {

	@Autowired
	private FinanceService service; 
	
	@RequestMapping("/final")
	public String viewHomePage(Model model) {
		System.out.println("in viewHomePage method");
		List<Finance> listProducts = service.listAll();
		CopyOnWriteArrayList<Finance> c = new CopyOnWriteArrayList<Finance>();
		Finance finances = new Finance();
	/*	for(int i=0;i<listProducts.size();i++) {
			finance.setCity(listProducts.get(i).getCity());
		}*/
		/*for(Finance f : listProducts) {
			finance.setCity(f.getCity());
			
		}*/
		
		//finance.setCity(city);
		//System.out.println("cities values" +finance);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("finances", finances);
		//System.out.println(listProducts.get(0));
		return "index";
	}
	
	@RequestMapping("/")
	public String viewData(Model model) {
		System.out.println("in viewHomePage method");
		List<Finance> listProducts = service.listAll();
		CopyOnWriteArrayList<Finance> c = new CopyOnWriteArrayList<Finance>();
		Finance finances = new Finance();
	/*	for(int i=0;i<listProducts.size();i++) {
			finance.setCity(listProducts.get(i).getCity());
		}*/
		/*for(Finance f : listProducts) {
			finance.setCity(f.getCity());
			
		}*/
		
		//finance.setCity(city);
		//System.out.println("cities values" +finance);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("finances", finances);
		//System.out.println(listProducts.get(0));
		return "home";
	}
	
	@RequestMapping("/citiesInfo")
	public String cityWiseInfo(Model model) {
		List<String> citieslist = service.getCitywiseInfo();
		//Finance finance = new Finance();
		//finance.setCity(citieslist);
		//String s =(String) citieslist.get(0).substring(0);
		//System.out.println("in cityWiseInfo Controller method" +citieslist.getCity());
		model.addAttribute("finance",citieslist);
		//cities.forEach(game->System.out.println(game));
		return "home";	//return city;
	}
	
	@RequestMapping(value = "/getPlace", method = RequestMethod.POST)
	public String cityWise(@ModelAttribute("listProducts") Finance finance, Model model) {
		System.out.println("city value in getplace method" +finance.getCity());
		//model.addAttribute("finance", finance.getCity());
		//model.addAttribute("listProducts",finance);
		String s = finance.getCity();
		List<Finance> cities = service.getCitywise(s);
		//System.out.println(cities.get(0).getName());
		model.addAttribute("listProducts",cities);
		//cities.forEach(game->System.out.println(game));
		return "index";	//return city;
	}
	
	@RequestMapping("/customer/{serielNumber}")
	public String customerWise(@PathVariable int serielNumber, Model model) {
		System.out.println("customer value" +serielNumber);
		Finance customer = service.getCustomerwise(serielNumber);
	//	System.out.println(customer.get(0).getName());
		model.addAttribute("listProducts",customer);
		//cities.forEach(game->System.out.println(game));
		return "index";	//return city;
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		
		Finance product = new Finance();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Finance product) {
		System.out.println("in saveProduct method");
		service.save(product);
		System.out.println("in saveProduct method after save");
		return "redirect:/final";
	}
	
	@RequestMapping("/edit/{serielNumber}")
	public ModelAndView showEditProductPage(@PathVariable int serielNumber) {
		System.out.println("id value is " +serielNumber);
		ModelAndView mav = new ModelAndView("edit_product");
		Finance product = service.get(serielNumber);
		mav.addObject("product", product);
		System.out.println("view name" +mav.getViewName());
	
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		service.delete(id);
		return "redirect:/final";		
	}
}
