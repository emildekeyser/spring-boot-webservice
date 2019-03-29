package umami;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import umami.model.Dish;
import umami.model.DishesRepository;
import umami.model.WeekMenuRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WeekMenuRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WeekMenuRepository weekMenuRepository;

    @Test
    public void whenFindAll_thenReturnAllDish() {
        // given
        Dish ok = DishBuilder.aMeatDish().build();
        // puts objects into the in-memory DB
        entityManager.persist(ok);
        entityManager.flush();

        Dish nok = DishBuilder.aVegDish().build();
        entityManager.persist(nok);
        entityManager.flush();

        // when
//        List<Dish> dishsFound = weekMenuRepository.findAll();

        // then
//        assertThat(dishsFound.size() == 2);
//        assertThat(dishsFound.contains(ok));
//        assertThat(dishsFound.contains(nok));
    }

    @Test
    public void whenFindByName_thenReturnDish() {
        // given
        Dish ok = DishBuilder.aMeatDish().build();
        entityManager.persist(ok);
        entityManager.flush();

        // when
//        Dish found = weekMenuRepository.findDishByName(ok.getName());

        // then
//        found.equals(ok);
    }
}
