package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.models.entities.ProductId;

public interface ProductService extends CrudService<Product, ProductId> {
	List<Product> findByCategory(Category category) throws Exception;
	List<Product> findByName(String name) throws Exception;
	List<Product> findByNameContaining(String name) throws Exception;
	
}
