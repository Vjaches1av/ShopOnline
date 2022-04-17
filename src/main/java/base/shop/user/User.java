package base.shop.user;

import base.shop.Basket;

public class User {
    public static final String DEFAULT_USERNAME = "Гость";
    private String username;
    private Basket basket;

    public User(String username, Basket basket) {
        setUsername(username);
        setBasket(basket);
    }

    public User(String username) {
        this(username, null);
    }

    public User() {
        this(null);
    }

    private String nonNullAlias(String alias) {
        return alias == null || alias.isBlank() ? DEFAULT_USERNAME : alias;
    }

    private Basket nonNullBasket(Basket basket) {
        return basket == null ? new Basket() : basket;
    }

    public void setUsername(String username) {
        this.username = nonNullAlias(username);
    }

    public void setBasket(Basket basket) {
        this.basket = nonNullBasket(basket);
    }

    public String getUsername() {
        return username;
    }

    public Basket getBasket() {
        return basket;
    }
}
