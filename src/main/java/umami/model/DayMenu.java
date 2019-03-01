package umami.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class DayMenu {
    @NotNull
    @NotEmpty
    private Day day;
    @NotNull
    @NotEmpty
    private Date date;
    @NotNull
    @NotEmpty
    private Dish soep;
    @NotNull
    @NotEmpty
    private Dish dagschotel;
    @NotNull
    @NotEmpty
    private Dish veggie;

    public DayMenu(@NotNull @NotEmpty Day day, @NotNull @NotEmpty Date date, @NotNull @NotEmpty Dish soep, @NotNull @NotEmpty Dish dagschotel, @NotNull @NotEmpty Dish veggie) {
        this.day = day;
        this.date = date;
        this.soep = soep;
        this.dagschotel = dagschotel;
        this.veggie = veggie;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Dish getSoep() {
        return soep;
    }

    public void setSoep(Dish soep) {
        this.soep = soep;
    }

    public Dish getDagschotel() {
        return dagschotel;
    }

    public void setDagschotel(Dish dagschotel) {
        this.dagschotel = dagschotel;
    }

    public Dish getVeggie() {
        return veggie;
    }

    public void setVeggie(Dish veggie) {
        this.veggie = veggie;
    }

}
