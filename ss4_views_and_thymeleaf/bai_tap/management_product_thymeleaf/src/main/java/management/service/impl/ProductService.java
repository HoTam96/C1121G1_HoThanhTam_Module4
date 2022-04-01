package management.service.impl;

import management.model.Product;
import management.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        Product product1 = new Product(1, "máy cày", 2000000d, "mày cày ruộng", "nhật bản");
        Product product2 = new Product(2, "máy nỗ", 3000000d, "mày cày ruộng", "mỹ");
        Product product3 = new Product(3, "máy bơm", 4000000d, "mày cày ruộng", "hàn quóc");
        Product product4 = new Product(4, "máy bung lúa", 2467000d, "mày cày ruộng", "nhật bản");
        Product product5 = new Product(5, "máy hút", 43570000d, "mày cày ruộng", "thái lan");
        Product product6 = new Product(6, "máy sấy", 4373000d, "mày cày ruộng", "nhật bản");

        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);
        productMap.put(product3.getId(), product3);
        productMap.put(product4.getId(), product4);
        productMap.put(product5.getId(), product5);
        productMap.put(product6.getId(), product6);
    }

    @Override
    public List<Product> getAllList() {
        List<Product> productList = new ArrayList<>(productMap.values());
        return productList;
    }

    @Override
    public Product productById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void insert(Product product) {
        Integer id = (int) (1000 * Math.random());
        product.setId(id);
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }
    @Override
    public void delete(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>(productMap.values());
        List<Product> list = new ArrayList<>();
        for (Product element : productList) {
            if (element.getProductName().contains(name)) {
                list.add(element);
            }
        }
        return list;
    }
}
