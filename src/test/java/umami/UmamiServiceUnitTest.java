package umami;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import umami.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Bridge between Spring Boot test features and JUnit
@RunWith(SpringRunner.class)
public class UmamiServiceUnitTest {

    private Dish dish;
    private Dish meatDish;
    private Dish vegDish;
    private List<Dish> dishes;
    private List<DayMenu> weekmenu;
    private DayMenu daymenu;

    @TestConfiguration
    static class UmamiServiceTestContextConfiguration {
        @Bean
        public UmamiService umamiService() {
            return new UmamiService();
        }
    }

    @Autowired
    private UmamiService umamiService;
    @MockBean
    private DishesRepository dishesRepository;
    @MockBean
    private WeekMenuRepository weekMenuRepository;

    @Before
    public void setUp() {
        dish = DishBuilder.aDish().build();
        meatDish = DishBuilder.aMeatDish().build();
        vegDish = DishBuilder.aVegDish().build();
        dishes = Arrays.asList(new Dish[]{dish, meatDish, vegDish});

        this.weekmenu = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            this.weekmenu.add(MenuBuilder.aMenu().build());
        }
        this.daymenu = this.weekmenu.get(0);
    }

    @Test
    public void getAllDishes() {
        Mockito.when(this.dishesRepository.findAll()).thenReturn(this.dishes);

        List<Dish> all = this.umamiService.getAllDishes();

        assertThat(all.size() == 3);
        assertThat(all.contains(this.dish));
        assertThat(all.contains(this.meatDish));
        assertThat(all.contains(this.vegDish));
    }

    @Test
    public void addDish() {
        testDaySaves();
    }

    @Test
    public void updatedish() {
        testDaySaves();
    }

    private void testDaySaves() {
        Mockito.when(this.dishesRepository.save(this.dish)).thenReturn(this.dish);

        this.umamiService.updateDish(this.dish);

        Mockito.verify(this.dishesRepository, Mockito.times(1))
                .save(this.dish);
    }

    @Test
    public void deleteByID() {
        this.umamiService.deleteByID(this.dish.getId());

        Mockito.verify(this.dishesRepository, Mockito.times(1))
                .deleteById(this.dish.getId());
    }

    @Test
    public void getdishbyid() {
        Mockito.when(this.dishesRepository.findDishById(this.dish.getId())).
                thenReturn(this.dish);

        assertThat(this.umamiService.getDishById(this.dish.getId()))
                .isEqualTo(this.dish);
    }

    @Test
    public void getweekmenu() {
        Mockito.when(this.weekMenuRepository.findAll()).thenReturn(this.weekmenu);

        List<DayMenu> week = this.umamiService.getWeekMenu();

//        assertThat(week.size() == 7);
//        assertThat(week.containsAll(this.weekmenu));
        assertThat(week).isEqualTo(this.weekmenu);
    }

    public void adddaymenu() {
        testMenuSaves();
    }

    public void updatedaymenu() {
        testMenuSaves();
    }

    private void testMenuSaves() {
        Mockito.when(this.weekMenuRepository.save(this.daymenu)).thenReturn(this.daymenu);

        this.umamiService.updateDayMenu(this.daymenu);

        Mockito.verify(this.weekMenuRepository, Mockito.times(1))
                .save(this.daymenu);
    }
}

