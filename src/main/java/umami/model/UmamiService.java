package umami.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UmamiService {

    @Autowired
    private DishesRepository dishesRepo;
    @Autowired
    private DayMenuRepository dayMenuRepo;
    @Autowired
    private WeekMenuRepository weekMenuRepo;


    // :::       ::: :::::::::: :::::::::: :::    :::   :::   :::   :::::::::: ::::    ::: :::    ::: 
   // :+:       :+: :+:        :+:        :+:   :+:   :+:+: :+:+:  :+:        :+:+:   :+: :+:    :+:  
  // +:+       +:+ +:+        +:+        +:+  +:+   +:+ +:+:+ +:+ +:+        :+:+:+  +:+ +:+    +:+   
 // +#+  +:+  +#+ +#++:++#   +#++:++#   +#++:++    +#+  +:+  +#+ +#++:++#   +#+ +:+ +#+ +#+    +:+    
// +#+ +#+#+ +#+ +#+        +#+        +#+  +#+   +#+       +#+ +#+        +#+  +#+#+# +#+    +#+     
// #+#+# #+#+#  #+#        #+#        #+#   #+#  #+#       #+# #+#        #+#   #+#+# #+#    #+#      
// ###   ###   ########## ########## ###    ### ###       ### ########## ###    ####  ########

    public List<WeekMenu> getWeekMenus(){
        return this.weekMenuRepo.findAll();
    }

    public Optional<WeekMenu> getWeekMenuById(int id){
        return this.weekMenuRepo.findById(id);
    }

      // :::::::::      :::   :::   :::  :::   :::   :::::::::: ::::    ::: :::    ::: 
     // :+:    :+:   :+: :+: :+:   :+: :+:+: :+:+:  :+:        :+:+:   :+: :+:    :+:  
    // +:+    +:+  +:+   +:+ +:+ +:+ +:+ +:+:+ +:+ +:+        :+:+:+  +:+ +:+    +:+   
   // +#+    +:+ +#++:++#++: +#++:  +#+  +:+  +#+ +#++:++#   +#+ +:+ +#+ +#+    +:+    
  // +#+    +#+ +#+     +#+  +#+   +#+       +#+ +#+        +#+  +#+#+# +#+    +#+     
 // #+#    #+# #+#     #+#  #+#   #+#       #+# #+#        #+#   #+#+# #+#    #+#      
// #########  ###     ###  ###   ###       ### ########## ###    ####  ########        

    public List<DayMenu> getDayMenus() {
        return this.dayMenuRepo.findAll();
    }

    public void addDayMenu(DayMenu dayMenu) {
        // No double courses
        this.commit(dayMenu);

        // Check if a new week needs to be created
        int weekId = dayMenu.getYearAndWeekNumber();
        WeekMenu weekWhereDayIsIn = this.weekMenuRepo.findById(weekId).orElse(new WeekMenu());
        if(weekWhereDayIsIn.isNew()){
            weekWhereDayIsIn.setId(weekId);
        }
        weekWhereDayIsIn.addDayMenu(dayMenu);

        this.weekMenuRepo.save(weekWhereDayIsIn);
    }

    private void commit(DayMenu dayMenu) {
        this.addDish(dayMenu.getSoep());
        this.addDish(dayMenu.getDagschotel());
        this.addDish(dayMenu.getVeggie());
        this.dayMenuRepo.save(dayMenu);
    }

    public void changeDayMenu(DayMenu dayMenu) {
        this.commit(dayMenu);
    }

    public void deleteDayMenu(LocalDate date){
        DayMenu dayMenu = this.dayMenuRepo.findById(date).orElseThrow(IllegalArgumentException::new);

        int weekMenuId = dayMenu.getYearAndWeekNumber();
        WeekMenu weekMenu = this.weekMenuRepo.findById(weekMenuId).orElseThrow(IllegalArgumentException::new);
        weekMenu.deleteDayMenu(dayMenu);
        this.weekMenuRepo.save(weekMenu);

        this.dayMenuRepo.deleteById(date);
    }

      // ::::::::: ::::::::::: ::::::::  :::    ::: 
     // :+:    :+:    :+:    :+:    :+: :+:    :+:  
    // +:+    +:+    +:+    +:+        +:+    +:+   
   // +#+    +:+    +#+    +#++:++#++ +#++:++#++    
  // +#+    +#+    +#+           +#+ +#+    +#+     
 // #+#    #+#    #+#    #+#    #+# #+#    #+#      
// ######### ########### ########  ###    ###       

    public List<Dish> getAllDishes() {
        return this.dishesRepo.findAll();
    }

    public Dish findDishByName(String name){
        return this.dishesRepo.findByName(name);
    }

    public Dish addDish(Dish dish) {
        Dish existing = this.dishesRepo.findByName(dish.getName());
        if(existing != null){
            dish.setId(existing.getId());
        }
        return this.dishesRepo.save(dish);
    }

    public void deleteDish(Dish dish) {
        this.dishesRepo.delete(dish);
    }

    public void updateDish(Dish dish) {
        this.dishesRepo.save(dish);
    }
}
