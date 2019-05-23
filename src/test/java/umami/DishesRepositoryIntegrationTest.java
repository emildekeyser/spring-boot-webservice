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
        Dish ok = DishBuilder.aMainCourse().build();
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
        Dish ok = DishBuilder.aMainCourse().build();
        entityManager.persist(ok);
        entityManager.flush();

        // when
        Dish found = dishesRepository.findByName(ok.getName());

        // then
        found.equals(ok);
    }

    @Test
    public void whenDeleteById_thenDishIsGone() {
        // given
        Dish ok = DishBuilder.aMainCourse().build();
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

    @Test
    public void saveUpdates() {
        // given
        Dish ok = DishBuilder.aMainCourse().build();
        entityManager.persist(ok);
        entityManager.flush();
        double newPrice = ok.getPrice() * 2;

        // when
        ok.setPrice(newPrice);
        this.dishesRepository.save(ok);

        // then
        assertThat(this.dishesRepository.findByName(ok.getName()).getPrice())
                .isEqualTo(newPrice);
    }
    public void saveDeletes(){
        // given
        Dish ok = DishBuilder.aMainCourse().build();
        entityManager.persist(ok);
        entityManager.flush();
        Dish nok = DishBuilder.aVegDish().build();

        // when
        this.dishesRepository.save(nok);

        // then
        assertThat(this.dishesRepository.findAll().size())
                .isEqualTo(2);
        assertThat(this.dishesRepository.findByName(nok.getName()))
                .isEqualTo(nok);
    }

}
