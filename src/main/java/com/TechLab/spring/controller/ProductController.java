package com.TechLab.spring.controller;
import com.TechLab.spring.entity.Product;
import com.TechLab.spring.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {

    private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> listarProductos() {
        return productService.listarProductos();
    }

    @PostMapping("/")
    public String crearProducto(@RequestBody Product product){
        return productService.crearProducto(product);
    }

    @PostMapping("/batch")
    public List<Product> crearProductos(@RequestBody List<Product> products ) {
        return productService.crearProductos(products);
    }

    @GetMapping("/find/{id}")
    public Product buscarProductos(@PathVariable Long id) {
        return productService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public String editarProducto(@PathVariable Long id, @RequestBody Product product) {
        return productService.editarProducto(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        return productService.eliminarProducto(id);
    }

}

