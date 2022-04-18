package base.shop.user;

import base.shop.Basket;
import log.ILogger;

public class User {
    public static final String DEFAULT_USERNAME = "Гость";
    private ILogger logger;
    private String username;
    private Basket basket;

    public User(ILogger logger, String username, Basket basket) {
        this.logger = logger;

        setUsername(username);
        setBasket(basket);
    }

    public User(ILogger logger, String username) {
        this(logger, username, null);
    }

    public User(ILogger logger) {
        this(logger, null);
    }

    private String nonNullAlias(String alias) {
        log("Проверка имени пользователя: " + alias);
        return alias == null || alias.isBlank() ? DEFAULT_USERNAME : alias;
    }

    private Basket nonNullBasket(Basket basket) {
        log("Проверка корзины: " + basket);
        return basket == null ? new Basket() : basket;
    }

    public void setUsername(String username) {
        this.username = nonNullAlias(username);
        log("Создано имя пользователя: " + this.username);
    }

    public void setBasket(Basket basket) {
        this.basket = nonNullBasket(basket);
        log("Создана корзина: " + this.basket);
    }

    private void log(String logText) {
        if (logger != null) {
            logger.log(logText);
        }
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public String getUsername() {
        return username;
    }

    public Basket getBasket() {
        return basket;
    }
}
