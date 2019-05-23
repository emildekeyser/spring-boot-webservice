package umami.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekMenuRepository extends JpaRepository<WeekMenu, Integer> {}
