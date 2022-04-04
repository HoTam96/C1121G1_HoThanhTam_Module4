package management.repository.impl;

import management.model.Product;
import management.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getAllList() {

        TypedQuery<Product> typedQuery = entityManager.
                createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product productById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(productById(id));
    }

    @Override
    public List<Product> search(String name) {
        TypedQuery<Product> productTypedQuery = entityManager.
                createQuery("select s from Product s where s.productName like ?1", Product.class);
        productTypedQuery.setParameter(1, "%" + name + "%");
        return productTypedQuery.getResultList();

    }
}
