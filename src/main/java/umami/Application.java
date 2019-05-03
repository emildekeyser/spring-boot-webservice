package umami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import umami.model.*;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    @Order(1)
//    public CommandLineRunner runnerDishes(DishesRepository dishesRepository) {
//        return dishArgs -> {
//            dishesRepository.save(new Dish("kak", "heel vies", 0.5, "VEGGIE"));
//            dishesRepository.save(new Dish("kak2", "heeldjlvies", 0.4, "VEGGIE"));
//            dishesRepository.save(new Dish("kak3", "heel dsfjgvies", 0.7, "VEGGIE"));
//        };
//    }
//
//    @Bean
//    @Order(2)
//    public CommandLineRunner runnerDays(WeekMenuRepository weekMenuRepository, DishesRepository dishesRepository) {
//        return DayArgs -> {
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 1),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 2),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 3),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 4),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 5),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 6),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//            weekMenuRepository.save(new DayMenu(LocalDate.of(2000, 1, 7),
//                    dishesRepository.findDishByName("kak"),
//                    dishesRepository.findDishByName("kak2"),
//                    dishesRepository.findDishByName("kak3")));
//        };
//    }

//    @Bean
//    @Order(3)
//    public CommandLineRunner runnerWeekss(WeekRepository weekRepository, DayRepository dayRepository) {
//        return WeekArgs -> {
//            Week week1 = new Week();
//            Day day = dayRepository.findById(LocalDate.of(2019, 4, 22)).orElseThrow(IllegalArgumentException::new);
//            int yearAndWeekNumber = day.getYearAndWeekNumber();
//            week1.setId(yearAndWeekNumber);
//
//            week1.addDay(day);
//            week1.addDay(dayRepository.findById(LocalDate.of(2019, 4, 23)).orElseThrow(IllegalArgumentException::new));
//            week1.addDay(dayRepository.findById(LocalDate.of(2019, 4, 24)).orElseThrow(IllegalArgumentException::new));
//            week1.addDay(dayRepository.findById(LocalDate.of(2019, 4, 25)).orElseThrow(IllegalArgumentException::new));
//            week1.addDay(dayRepository.findById(LocalDate.of(2019, 4, 26)).orElseThrow(IllegalArgumentException::new));
//
//            weekRepository.save(week1);
//
//            Week week2 = new Week();
//            day = dayRepository.findById(LocalDate.of(2019, 4, 29)).orElseThrow(IllegalArgumentException::new);
//            yearAndWeekNumber = day.getYearAndWeekNumber();
//            week2.setId(yearAndWeekNumber);
//
//            week2.addDay(day);
//            week2.addDay(dayRepository.findById(LocalDate.of(2019, 4, 30)).orElseThrow(IllegalArgumentException::new));
//            week2.addDay(dayRepository.findById(LocalDate.of(2019, 5, 1)).orElseThrow(IllegalArgumentException::new));
//            week2.addDay(dayRepository.findById(LocalDate.of(2019, 5, 2)).orElseThrow(IllegalArgumentException::new));
//            week2.addDay(dayRepository.findById(LocalDate.of(2019, 5, 3)).orElseThrow(IllegalArgumentException::new));
//
//            weekRepository.save(week2);
//        };
//    }
}

