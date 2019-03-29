package umami;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import umami.model.Dish;
import umami.model.DishesRepository;
import umami.model.UmamiService;
import umami.model.WeekMenuRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Bridge between Spring Boot test features and JUnit
@RunWith(SpringRunner.class)
public class UmamiServiceUnitTest {

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
        Dish dish = DishBuilder.aDish().build();
        Dish meatDish = DishBuilder.aMeatDish().build();
        Dish vegDish = DishBuilder.aVegDish().build();
        List<Dish> dishes = Arrays.asList(new Dish[]{dish, meatDish, vegDish});

        Mockito.when(dishesRepository.findAll()).thenReturn(dishes);
        Mockito.when(dishesRepository.findDishById(dish.getId())).thenReturn(dish);
//        Mockito.when(weekMenuRepository.findAll(ok.getName())).thenReturn(dish);
//        public List<Dish> getAllDishes() {
//        public void addDish(Dish dish) {
//        public void deleteByID(Long id) {
//        public void updatedish(dish dish) {
//        public dish getdishbyid(long id) {
//        public list<daymenu> getweekmenu() {
//        public void adddaymenu(daymenu daymenu) {
//        public void updatedaymenu(daymenu daymenu) {
    }

    @Test
    public void whenNewFeedback_thenFeedbackShouldBeFound() {
        // given
//        String name = "Elke";
//        String feedback = "OK";
//
//        // when
//        Feedback found = umamiService.findFeedbackByName(name);
//
//        // then
//        assertThat(found.getName()).isEqualTo(name);
//        assertThat(found.getFeedback()).isEqualTo(feedback);
    }
}

