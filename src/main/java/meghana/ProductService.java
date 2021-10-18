package meghana;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service
public class ProductService {
	@Autowired
    private ProductRepository productrepository;
     
    public List<Product> listAll() {
        return productrepository.findAll();
    }
     
    public void save(Product product) {
    	productrepository.save(product);
    }
     
    public Product get(long id) {
        return productrepository.findById(id).get();
    }
     
    public void delete(long id) {
    	productrepository.deleteById(id);
    }
}
