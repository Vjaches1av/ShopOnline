package base.menu;

import base.shop.user.User;
import base.shop.Shop;

import java.util.Scanner;

public class UserMenu implements Menu {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final String[] userActions = {
            "Узнать список доступных товаров",
            "Выбрать товар",
            "Удалить товар",
            "Узнать список выбранных товаров",
            "Завершить сеанс"
    };

    private User user;
    private Shop shop;

    public UserMenu(User user, Shop shop) {
        setUser(user);
        setShop(shop);
    }

    private User nonNullUser(User user) {
        return user == null ? new User() : user;
    }

    public void setUser(User user) {
        this.user = nonNullUser(user);
    }

    public void setShop(Shop shop) {
        if (shop == null) {
            throw new IllegalArgumentException("Не установлено взаимодействие с магазином");
        } else {
            this.shop = shop;
        }
    }

    @Override
    public boolean execute(int i) {
        switch (i) {
            case 1:
                shop.display();
                break;
            case 2:
                shop.display();
                System.out.print("Укажите порядковый номер товара: ");
                user.getBasket().add(shop.getProduct(Integer.parseInt(SCANNER.nextLine())));
                break;
            case 3:
                shop.display();
                System.out.print("Укажите порядковый номер товара: ");
                user.getBasket().remove(shop.getProduct(Integer.parseInt(SCANNER.nextLine())));
                break;
            case 4:
                user.getBasket().display();
                break;
            case 5:
                return false;
            default:
                throw new IllegalArgumentException("Недопустимый вариант выбора");
        }

        return true;
    }

    @Override
    public void display() {
        System.out.print(System.lineSeparator());
        for (int i = 0; i < userActions.length; i++) {
            System.out.printf("%d. %s" + System.lineSeparator(), i + 1, userActions[i]);
        }
    }
}
