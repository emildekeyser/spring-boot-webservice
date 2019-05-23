package umami.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

@Entity
public class WeekMenu {
    @Id
    private int id = 0;

    @OneToMany
//    @MapKeyColumn(name = "daymenu_number")
//    @MapKeyColumn(name = "day_number")
    private Map<Integer, DayMenu> week = new HashMap<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {return this.id;}

    public Map<Integer, DayMenu> getWeek() {
        return week;
    }

    public void setWeek(Map<Integer, DayMenu> week) {
        this.week = week;
    }

    public void addDayMenu(DayMenu dayMenu){
        this.week.put(dayMenu.getDayOfWeek(), dayMenu);
    }

    public void deleteDayMenu(DayMenu dayMenu) {
        this.week.remove(dayMenu.getDayOfWeek());
    }

    @JsonIgnore
    public boolean isNew() {
        return this.id == 0;
    }
}
