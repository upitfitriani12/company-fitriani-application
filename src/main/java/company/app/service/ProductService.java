package company.app.service;

import company.app.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getNonExpiredProducts();
    List<Product> getExpiredProducts();
    Product getProductById(Integer id);
    Product updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    List<Product> getProductsByPriceRange(Integer minPrice, Integer maxPrice);
}
