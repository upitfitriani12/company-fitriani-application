package company.app.service.impl;

import company.app.entity.Product;
import company.app.repository.ProductRepository;
import company.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getNonExpiredProducts() {
        return productRepository.findByExpiryDateAfter(LocalDate.now());
    }

    @Override
    public List<Product> getExpiredProducts() {
        return productRepository.findExpiredProducts();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getProductsByPriceRange(Integer minPrice, Integer maxPrice) {
        return productRepository.findProductsByPriceRange(minPrice, maxPrice);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
