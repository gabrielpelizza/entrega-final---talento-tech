package com.TechLab.spring.service;

import com.TechLab.spring.entity.Product;
import com.TechLab.spring.interfaces.IProductService;
import com.TechLab.spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public String crearProducto(Product product) {
        repo.save(product);
        return "Producto creado correctamente";
    }

    public List<Product> crearProductos( List<Product> products) {
        return repo.saveAll(products);
    }

    @Override
    public List<Product> listarProductos() {
        return repo.findAll();
    }

    @Override
    public Product buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String editarProducto(Long id, Product product) {
        return repo.findById(id).map(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            repo.save(p);
            return "Producto actualizado correctamente";
        }).orElse("Producto no encontrado");
    }

    @Override
    public String eliminarProducto(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Producto eliminado correctamente";
        }
        return "Producto no encontrado";
    }
}

