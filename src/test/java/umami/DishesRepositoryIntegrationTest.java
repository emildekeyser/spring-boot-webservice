package umami;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import umami.model.Dish;
import umami.model.DishesRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DishesRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DishesRepository dishesRepository;

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
        List<Dish> dishsFound = dishesRepository.findAll();

        // then
        assertThat(dishsFound.size() == 2);
        assertThat(dishsFound.contains(ok));
        assertThat(dishsFound.contains(nok));
    }

    @Test
    public void whenFindByName_thenReturnDish() {
        // given
        Dish ok = DishBuilder.aMeatDish().build();
        entityManager.persist(ok);
        entityManager.flush();

        // when
        Dish found = dishesRepository.findDishByName(ok.getName());

        // then
        found.equals(ok);
    }

    @Test
    public void whenDeleteById_thenDishIsGone()
    {
        // given
        Dish ok = DishBuilder.aMeatDish().build();
        entityManager.persist(ok);
        entityManager.flush();
        Dish nok = DishBuilder.aVegDish().build();
        entityManager.persist(nok);
        entityManager.flush();
        // when
        dishesRepository.deleteById(nok.getId());
        List<Dish> dishesFound = dishesRepository.findAll();
        // then
        assertThat(dishesFound.size() == 1);
        assertThat(dishesFound.contains(ok));
        assertThat(!dishesFound.contains(nok));
    }

}
