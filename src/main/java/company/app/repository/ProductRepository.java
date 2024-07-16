package company.app.repository;

import company.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByExpiryDateAfter(LocalDate date);

    @Query(value = "SELECT * FROM tbl_product WHERE expired = true", nativeQuery = true)
    List<Product> findExpiredProducts();

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceRange(@Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);
}
