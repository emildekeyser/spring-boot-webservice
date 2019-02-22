package umami.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UmamiService {
    List<Dish> dishes = new ArrayList<Dish>();
    // thread safe int to set id in feedback
    private AtomicInteger nextId = new AtomicInteger();

    // hardcode some values, definitively not the way to go !!!!
    public UmamiService() {
        dishes.add(new Dish(nextId.incrementAndGet(), "Bloemkoolsoep", "Bloemkoolsoep", 1));
        dishes.add(new Dish(nextId.incrementAndGet(), "Tomatensoep", "Tomatensoep", 1));
        dishes.add(new Dish(nextId.incrementAndGet(), "Pompoensoep", "Pompoensoep", 1));
        dishes.add(new Dish(nextId.incrementAndGet(), "Cordon Bleu", "Cordon", 4.20));
        dishes.add(new Dish(nextId.incrementAndGet(), "Konijn met pruimen", "Konijn", 4.30));
        dishes.add(new Dish(nextId.incrementAndGet(), "Groentelasagne", "Groentelasagne", 4));
        dishes.add(new Dish(nextId.incrementAndGet(), "Veggie Pasta", "Veggie", 5));
    }

    // just return the whole list, JSP page takes care of presentation
    public List<Dish> getAllDishes() {
        return dishes;
    }

    // look for a feedback by id (see umami.controller)
//    public Dish findFeedbackById(int id) {
//        for(Dish feedback : feedbacks){
//            if(feedback.getId() == id){
//                return feedback;
//            }
//        }
//        //return null;
//        // beter nog: throw exception!
//        throw new IllegalArgumentException("You really messed up your numbers!");
//    }
//
//    // look for a feedback by name (see umami.controller)
//    public Dish findFeedbackByName(String name) {
//        for(Dish feedback : feedbacks){
//            if(name.equals(feedback.getName())){
//                return feedback;
//            }
//        }
//        return null;
//        // beter nog: throw exception!
//    }
//
    public void addDish(Dish dish) {
        dish.setId(nextId.incrementAndGet());
        dishes.add(dish);
    }

    public void deleteByID(int id) {
        dishes.remove(getDishById(id));
    }

    public Dish getDishById(int id) {
        for (Dish d : dishes) {
            if (d.getId() == id) {
                return d;
            }
        }
        throw new RuntimeException("NON EXISTANT DISH");
    }

    public void updateDish(Dish dish) {
        deleteByID(dish.getId());
        addDish(dish);
    }
}