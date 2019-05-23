package umami;

import umami.model.DayMenu;
import umami.model.Dish;

import java.time.LocalDate;

public class MenuBuilder {
    private LocalDate date;
    private Dish soep;
    private Dish dagschotel;
    private Dish veggie;

    public static MenuBuilder aMenu() {
        return new MenuBuilder()
                .withDate(LocalDate.now())
                .withSoep(DishBuilder.aSoup().build())
                .withDagschotel(DishBuilder.aMainCourse().build())
                .withVeggie(DishBuilder.aVegDish().build());
    }

    public MenuBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public MenuBuilder withSoep(Dish soep) {
        this.soep = soep;
        return this;
    }


    public MenuBuilder withDagschotel(Dish dagschotel) {
        this.dagschotel = dagschotel;
        return this;
    }

    public MenuBuilder withVeggie(Dish veggie) {
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


