package com.TechLab.spring.interfaces;
import com.TechLab.spring.entity.Product;
import java.util.List;

public interface IProductService {
    String crearProducto(Product producto);
    List<Product> listarProductos();
    Product buscarPorId(Long id);
    String editarProducto(Long id, Product producto);
    String eliminarProducto(Long id);
}
