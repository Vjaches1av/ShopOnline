package base.shop;

import base.Displayed;

import java.util.HashMap;
import java.util.Map;

public class Basket implements Displayed {
    private Map<Product, Integer> container; // Контейнер товаров и их количества

    public Basket(Map<Product, Integer> container) {
        setContainer(container);
    }

    public Basket() {
        this(null);
    }

    private Map<Product, Integer> nonNullContainer(Map<Product, Integer> container) {
        return container == null ? new HashMap<>() : container;
    }

    public void setContainer(Map<Product, Integer> container) {
        this.container = nonNullContainer(container);
    }

    public void add(Product product) {
        if (container.containsKey(product)) {
            container.put(product, container.get(product) + 1);
        } else {
            container.put(product, 1);
        }
    }

    public void remove(Product product) {
        if (container.containsKey(product)) {
            if (container.get(product) > 1) {
                container.put(product, container.get(product) - 1);
            } else {
                container.remove(product);
            }
        }
    }

    public int calculateTotalCost() {
        int amount = 0;
        for (Map.Entry<Product, Integer> entry : container.entrySet()) {
            int price = entry.getKey().getPrice();
            int num = entry.getValue();
            amount += price * num;
        }
        return amount;
    }

    public void display() {
        int count = 0;

        System.out.print(System.lineSeparator());
        System.out.println("Список выбранных товаров:");
        for (Map.Entry<Product, Integer> entry : container.entrySet()) {
            Product product = entry.getKey();
            Integer number = entry.getValue();
            System.out.printf("%d. %s x %d = %d руб." + System.lineSeparator(),
                    ++count, product, number, product.getPrice() * number);
        }
        System.out.printf("ИТОГО: %d руб." + System.lineSeparator(), calculateTotalCost());
    }
}
