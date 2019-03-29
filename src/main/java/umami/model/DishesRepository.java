package umami.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesRepository extends JpaRepository<Dish, Long>
{
    Dish findDishByName(String name);
    Dish findDishById(Long id);
    void deleteById(Long id);
}
