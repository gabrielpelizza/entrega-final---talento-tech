package com.TechLab.spring.controller;
import com.TechLab.spring.entity.Product;
import com.TechLab.spring.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {

    private  ProductService productoService;

    public ProductController(ProductService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/list")
    public List<Product> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/")
    public String crearProducto(@RequestBody Product product){
        return productoService.crearProducto(product);
    }

    @PostMapping("/batch")
    public List<Product> crearProductos(@RequestBody List<Product> products ) {
        return productoService.crearProductos(products);
    }

    @GetMapping("/find/{id}")
    public Product buscarProductos(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public String editarProducto(@PathVariable Long id, @RequestBody Product product) {
        return productoService.editarProducto(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

}

