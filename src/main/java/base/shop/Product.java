package base.shop;

public enum Product {
    TV("Телевизор", 29_999),
    LAPTOP("Ноутбук", 31_999),
    IRON("Утюг", 6_299);

    private final String title;
    private final int price;

    Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + ": " + price + " руб.";
    }
}
