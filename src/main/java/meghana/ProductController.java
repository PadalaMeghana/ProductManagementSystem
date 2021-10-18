package meghana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ProductController {
	@Autowired
    private ProductService productservice;
	@RequestMapping("/")
	public String viewHomePage(Model m) {
	    List<Product> listProducts = productservice.listAll();
	    m.addAttribute("listProducts", listProducts);
	     
	    return "index";
	}
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
	    productservice.save(product);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Product product = productservice.get(id);
	    mav.addObject("product", product);
	     
	    return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    productservice.delete(id);
	    return "redirect:/";       
	}
}
