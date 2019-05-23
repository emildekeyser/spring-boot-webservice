package umami;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import umami.model.*;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Order(1)
    @Profile("!RESTUnitTest")
    public CommandLineRunner runnerDishes(DishesRepository dishesRepository) {
        return dishArgs -> {
            dishesRepository.save(new Dish("kak", "heel vies", 0.5, DishType.Soup));
            dishesRepository.save(new Dish("kak2", "heeldjlvies", 0.4, DishType.MainCourse));
            dishesRepository.save(new Dish("kak3", "heel dsfjgvies", 0.7, DishType.Veggie));
        };
    }

    @Bean
    @Order(2)
    @Profile("!RESTUnitTest")
    public CommandLineRunner runnerDays(DayMenuRepository dayMenuRepository, DishesRepository dishesRepository) {
        return DayMenuArgs -> {
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 22),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 23),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 24),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 25),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 26),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));

            // new week

            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 29),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 4, 30),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 5, 1),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 5, 2),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
            dayMenuRepository.save(new DayMenu(LocalDate.of(2019, 5, 3),
                    dishesRepository.findByName("kak"),
                    dishesRepository.findByName("kak2"),
                    dishesRepository.findByName("kak3")));
        };
    }

    @Bean
    @Order(3)
    @Profile("!RESTUnitTest")
    public CommandLineRunner runnerWeekss(WeekMenuRepository weekMenuRepository, DayMenuRepository dayMenuRepository) {
        return WeekArgs -> {
            WeekMenu week1 = new WeekMenu();
            DayMenu day = dayMenuRepository.findById(LocalDate.of(2019, 4, 22)).orElseThrow(IllegalArgumentException::new);
            int yearAndWeekNumber = day.getYearAndWeekNumber();
            week1.setId(yearAndWeekNumber);

            week1.addDayMenu(day);
            week1.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 4, 23)).orElseThrow(IllegalArgumentException::new));
            week1.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 4, 24)).orElseThrow(IllegalArgumentException::new));
            week1.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 4, 25)).orElseThrow(IllegalArgumentException::new));
            week1.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 4, 26)).orElseThrow(IllegalArgumentException::new));

            weekMenuRepository.save(week1);

            WeekMenu week2 = new WeekMenu();
            day = dayMenuRepository.findById(LocalDate.of(2019, 4, 29)).orElseThrow(IllegalArgumentException::new);
            yearAndWeekNumber = day.getYearAndWeekNumber();
            week2.setId(yearAndWeekNumber);

            week2.addDayMenu(day);
            week2.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 4, 30)).orElseThrow(IllegalArgumentException::new));
            week2.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 5, 1)).orElseThrow(IllegalArgumentException::new));
            week2.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 5, 2)).orElseThrow(IllegalArgumentException::new));
            week2.addDayMenu(dayMenuRepository.findById(LocalDate.of(2019, 5, 3)).orElseThrow(IllegalArgumentException::new));

            weekMenuRepository.save(week2);
        };
    }
}

