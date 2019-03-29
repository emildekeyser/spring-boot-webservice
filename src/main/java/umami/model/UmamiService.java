package umami.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UmamiService {

    @Autowired
    private DishesRepository dishesRepo;
    @Autowired
    private WeekMenuRepository weekMenuRepo;

    public List<Dish> getAllDishes() {
        return this.dishesRepo.findAll();
    }

    public void addDish(Dish dish) {
        this.dishesRepo.save(dish);
    }

    public void deleteByID(Long id) {
        this.dishesRepo.deleteById(id);
    }

    public void updateDish(Dish dish) {
        this.dishesRepo.save(dish);
    }

    public Dish getDishById(Long id) {
        return this.dishesRepo.findDishById(id);
    }

    public List<DayMenu> getWeekMenu() {
        return this.weekMenuRepo.findAll();
    }

    public void addDayMenu(DayMenu dayMenu) {
        this.weekMenuRepo.save(dayMenu);
    }

    public void updateDayMenu(DayMenu dayMenu) {
        this.weekMenuRepo.save(dayMenu);
    }

}
