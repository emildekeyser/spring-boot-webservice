package umami.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class DayMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //    @NotNull
//    @NotEmpty
    private Date date;
    //    @NotNull
//    @NotEmpty
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dish soep;
    //    @NotNull
//    @NotEmpty
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dish dagschotel;
    //    @NotNull
//    @NotEmpty
    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Dish veggie;

    public String getDay() {
        return new SimpleDateFormat("EE").format(this.date);
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
