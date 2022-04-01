package management.service;

import management.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllList();

    Product productById(Integer id);

    void insert(Product product);

    void update(Product product);

    void delete(Integer id);

    List<Product> search(String name);
}
