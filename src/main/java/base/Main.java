package base;

import base.menu.IMenu;
import base.menu.UserMenu;
import base.shop.Product;
import base.shop.Shop;
import base.shop.user.User;
import log.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        Product[] products = Product.values();
        Shop shop = new Shop(products);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("ИНТЕРНЕТ-МАГАЗИН ТЕХНИКИ И ЭЛЕКТРОНИКИ");
            System.out.print("Как к Вам обращаться? ");
            User user = new User(logger, scanner.nextLine());
            System.out.printf("Здравствуйте, %s! Добро пожаловать в наш интернет-магазин!" + System.lineSeparator(),
                    user.getUsername());
            IMenu menu = new UserMenu(user, shop);
            while (true) {
                menu.display();
                System.out.print("Выберите нужное действие: ");
                int i = Integer.parseInt(scanner.nextLine());
                if (!menu.execute(i)) {
                    break;
                }
            }
        }
    }
}
