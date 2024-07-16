package company.app.controller;

import company.app.entity.Product;
import company.app.service.ProductService;
import company.app.utils.response.PagingInfo;
import company.app.utils.response.WebResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<WebResponse<Product>> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        WebResponse<Product> response = WebResponse.<Product>builder()
                .message("Product created successfully")
                .data(createdProduct)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        PagingInfo pagingInfo = new PagingInfo(products.size(), 1, 1, products.size()); // Example paging info
        WebResponse<List<Product>> response = WebResponse.<List<Product>>builder()
                .message("All Product Successfully Displayed")
                .data(products)
                .paging(pagingInfo)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nonExpired")
    public ResponseEntity<WebResponse<List<Product>>> getNonExpiredProducts() {
        List<Product> products = productService.getNonExpiredProducts();
        PagingInfo pagingInfo = new PagingInfo(products.size(), 1, 1, products.size());
        WebResponse<List<Product>> response = WebResponse.<List<Product>>builder()
                .message("Products that are not Expired are successfully found")
                .data(products)
                .paging(pagingInfo)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/expired")
    public ResponseEntity<WebResponse<List<Product>>> getExpiredProducts() {
        List<Product> products = productService.getExpiredProducts();
        PagingInfo pagingInfo = new PagingInfo(products.size(), 1, 1, products.size()); // Example paging info
        WebResponse<List<Product>> response = WebResponse.<List<Product>>builder()
                .message("Expired Products Successfully Found ")
                .data(products)
                .paging(pagingInfo)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<Product>> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        WebResponse<Product> response = WebResponse.<Product>builder()
                .message("Product ID successfully found")
                .data(product)
                .build();
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WebResponse<Product>> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        WebResponse<Product> response = WebResponse.<Product>builder()
                .message("Product updated successfully")
                .data(updatedProduct)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<Void>> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        WebResponse<Void> response = WebResponse.<Void>builder()
                .message("Product deleted successfully")
                .build();
        return ResponseEntity.ok(response);
    }
}
