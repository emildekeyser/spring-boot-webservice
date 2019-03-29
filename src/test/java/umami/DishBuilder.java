package umami;

import umami.model.Dish;

public class DishBuilder {

    private String name;
    private String description;
    private double price;
    private String type;

    private DishBuilder() {}

    public static DishBuilder aDish () {
        return new DishBuilder();
    }

    public static DishBuilder aVegDish () {
        return aDish()
                .withName("Kak met bonen")
                .withDescription("heel erg vies")
                .withPrice(4.56)
                .withType("VEGGIE");
    }

    public static DishBuilder aMeatDish () {
        return aDish()
                .withName("Meat")
                .withDescription("heel erg lekker")
                .withPrice(8.56)
                .withType("DAGSCHOTEL");
    }

    private DishBuilder withType(String type) {
        this.type = type;
        return this;
    }

    private DishBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public DishBuilder withName (String name) {
        this.name = name;
        return this;
    }

    public DishBuilder withDescription (String description) {
        this.description = description;
        return this;
    }

    public Dish build() {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setDescription(this.description);
        return dish;
    }
}

