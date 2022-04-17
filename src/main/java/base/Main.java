package base;

import base.menu.Menu;
import base.menu.UserMenu;
import base.shop.Product;
import base.shop.Shop;
import base.shop.user.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product[] products = Product.values();
        Shop shop = new Shop(products);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("ИНТЕРНЕТ-МАГАЗИН ТЕХНИКИ И ЭЛЕКТРОНИКИ");
            System.out.print("Как к Вам обращаться? ");
            User user = new User(scanner.nextLine());
            System.out.printf("Здравствуйте, %s! Добро пожаловать в наш интернет-магазин!" + System.lineSeparator(),
                    user.getUsername());
            Menu menu = new UserMenu(user, shop);
            while (true) {
                menu.display();
                System.out.print("Выберите нужное действие: ");
                if (!menu.execute(Integer.parseInt(scanner.nextLine()))) {
                    return;
                }
            }
        }
    }
}
