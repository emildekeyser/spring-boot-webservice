package umami.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

@Entity
@Table(name = "daymenu")
public class DayMenu {
    @Id
    @NotNull
    private LocalDate date;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH})
    private Dish soep;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH})
    private Dish dagschotel;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH})
    private Dish veggie;

    // Internal fields
    private int dayOfWeek;
    private String dayName;
    private int yearAndWeekNumber;

    public DayMenu(){}

    public DayMenu(LocalDate date, Dish soep, Dish dagschotel, Dish veggie){
        this.setDate(date);
        this.setSoep(soep);
        this.setDagschotel(dagschotel);
        this.setVeggie(veggie);
    }

    public LocalDate getDate() { return this.date; }
    public void setDate(LocalDate date) {
        this.date = date;
        this.setDayName();
        this.setYearAndWeekNumber();
        this.setDayOfWeek();
    }

    private void setDayOfWeek() {
        // need this to get the number of the day in the week - 1 = monday, 2 = tuesday, ...
        TemporalField weekOfWeekBasedYear = WeekFields.ISO.dayOfWeek();
        this.dayOfWeek = this.date.get(weekOfWeekBasedYear);
    }

    private void setYearAndWeekNumber() {
        // need this to get the number of the week in the year => 1st week, 2nd week, ...
        TemporalField weekOfWeekBasedYear = WeekFields.ISO.weekOfWeekBasedYear();
        String y = String.valueOf(this.date.getYear());
        // make sure we have a zero in front of a 1 digit weekNumber
        String wn = String.format("%02d", this.date.get(weekOfWeekBasedYear));
        // this puts the year and the week after each other:
        // eg. 201917 for year 2019 and week 17 or 201907 for year 2019 and week 7
        this.yearAndWeekNumber = Integer.parseInt(y + wn);
    }

    private void setDayName() {
        this.dayName = this.date.getDayOfWeek().toString();
        this.dayName = dayName.charAt(0) + dayName.substring(1).toLowerCase(); // only first letter uppercase
    }

    public int getDayOfWeek() { return this.dayOfWeek; }
    public String getDayName() { return this.dayName; }
    public int getYearAndWeekNumber() { return this.yearAndWeekNumber; }

    public void setDayOfWeek(int a) {}
    public void setDayName(String a) {}
    public void setYearAndWeekNumber(int a) {}

    public Dish getSoep() { return soep; }
    public void setSoep(Dish soep) {
        if(!soep.getType().equals(DishType.Soup)) {
            throw new IllegalArgumentException("Not a soup");
        }
        this.soep = soep;
    }

    public Dish getDagschotel() { return dagschotel; }
    public void setDagschotel(Dish dagschotel) {
        if(!dagschotel.getType().equals(DishType.MainCourse)) {
            throw new IllegalArgumentException("Not a Main course");
        }
        this.dagschotel = dagschotel;
    }

    public Dish getVeggie() { return veggie; }
    public void setVeggie(Dish veggie) {
        if(!veggie.getType().equals(DishType.Veggie)) {
            throw new IllegalArgumentException("Not Veggie");
        }
        this.veggie = veggie;
    }

    @Override
    public boolean equals(Object o) {
       if (o instanceof DayMenu){
           DayMenu d = (DayMenu) o;
           if(d.getDate().equals(this.getDate())) {
               return true;
           }
       }
       return false;
    }

}
