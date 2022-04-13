package com.example.model;

import java.util.HashMap;
import java.util.Map;


public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean checkIntemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public void addNewProduct(Product product) {
        if (!checkIntemInCart(product)) {
            products.put(product, 1);
        } else {
            int amount = products.get(product) + 1;
            products.put(product, amount);
        }

    }

    public Integer countNumberProduct() {
        Integer amount = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            amount += entry.getValue();
        }
        return amount;
    }

    public Integer countItempProduct() {
      return   products.size();

    }

    public double totalPrice(){
        double payment = 0;
        for (Map.Entry<Product,Integer>entry:products.entrySet()){
           payment+= Double.parseDouble(entry.getKey().getPrice()) * entry.getValue();

        }
        return payment;
//        float payment = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;


    }


}
