package base.shop;

import base.Displayed;

import java.util.*;

public class Shop implements Displayed {
    private List<Product> products;

    public Shop(List<Product> products) {
        setProducts(products);
    }

    public Shop(Product[] products) {
        this(convertToList(products));
    }

    public Shop() {
        this((List<Product>) null);
    }

    private List<Product> nonNullProducts(List<Product> products) {
        return products == null ? new ArrayList<>() : products;
    }

    private void setProducts(List<Product> products) {
        this.products = nonNullProducts(products);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public Product getProduct(Product product) {
        if (products.contains(product)) {
            return product;
        } else {
            throw new IllegalArgumentException("Товар отсутствует");
        }
    }

    public Product getProduct(int index) {
        index -= 1;
        if (index >= 0 && index < products.size()) {
            return getProduct(products.get(index));
        } else {
            throw new IllegalArgumentException("Данная позиция отсутствует");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public int countNumberProducts() {
        return products.size();
    }

    @Override
    public void display() {
        System.out.print(System.lineSeparator());
        System.out.println("Список доступных товаров:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s" + System.lineSeparator(), i + 1, products.get(i));
        }
    }

    private static List<Product> convertToList(Product[] products) {
        if (products == null) {
            return null;
        }

        List<Product> list = new ArrayList<>(products.length);
        Collections.addAll(list, products);
        return list;
    }
}
