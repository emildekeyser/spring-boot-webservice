package umami;

import umami.model.DayMenu;
import umami.model.Dish;

import java.util.Date;

public class MenuBuilder {
    private Date date;
    private Dish soep;
    private Dish dagschotel;
    private Dish veggie;

    public static MenuBuilder aMenu() {
        return new MenuBuilder()
                .withDate(new Date())
                .withSoep(DishBuilder.aDish().build())
                .withDagschotel(DishBuilder.aMeatDish().build())
                .withVeggie(DishBuilder.aVegDish().build());
    }

    private MenuBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    private MenuBuilder withSoep(Dish soep) {
        this.soep = soep;
        return this;
    }


    private MenuBuilder withDagschotel(Dish dagschotel) {
        this.dagschotel = dagschotel;
        return this;
    }

    private MenuBuilder withVeggie(Dish veggie) {
        this.veggie = veggie;
        return this;
    }

    public DayMenu build() {
        DayMenu menu = new DayMenu();
        menu.setDate(this.date);
        menu.setSoep(this.soep);
        menu.setDagschotel(this.dagschotel);
        menu.setVeggie(this.veggie);
        return menu;
    }
}


