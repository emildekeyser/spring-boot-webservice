package umami;

import umami.model.Dish;
import umami.model.DishType;

public class DishBuilder {

    private String name;
    private String description;
    private double price;
    private DishType type;

    private DishBuilder() {}

    public static DishBuilder aDish () {
        return new DishBuilder();
    }

    public static DishBuilder aVegDish () {
        return aDish()
                .withName("Kak met bonen")
                .withDescription("heel erg vies")
                .withPrice(4.56)
                .withType(DishType.Veggie);
    }

    public static DishBuilder aMainCourse() {
        return aDish()
                .withName("Meat")
                .withDescription("heel erg lekker")
                .withPrice(8.56)
                .withType(DishType.MainCourse);
    }

    public static DishBuilder aSoup() {
        return aDish()
                .withName("vatzige soep")
                .withDescription(" dwijlwater")
                .withPrice(454)
                .withType(DishType.Soup);
    }

    private DishBuilder withType(DishType type) {
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
        dish.setPrice(this.price);
        dish.setType(this.type);
        return dish;
    }
}

