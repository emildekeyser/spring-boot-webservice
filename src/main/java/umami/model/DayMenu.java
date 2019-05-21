package umami.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.time.LocalDate;

@Entity
public class DayMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private String date;

    @NotNull
//    @NotEmpty
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dish soep;
    @NotNull
//    @NotEmpty
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dish dagschotel;
    @NotNull
//    @NotEmpty
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dish veggie;

    public DayMenu(String date, Dish soep, Dish dagschotel, Dish veggie){
        this.date = date;
        this.soep = soep;
        this.dagschotel = dagschotel;
        this.veggie = veggie;
    }

    public DayMenu(){}

//    public String getDay() {
//        return new SimpleDateFormat("EE").format(this.date);
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
