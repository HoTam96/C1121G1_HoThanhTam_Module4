package management.service.impl;

import management.model.Product;
import management.repository.IProductRepository;
import management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAllList() {
        return iProductRepository.getAllList();
    }

    @Override
    public Product productById(Integer id) {
        return iProductRepository.productById(id);
    }

    @Override
    public void insert(Product product) {
        iProductRepository.insert(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
