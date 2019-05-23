package umami.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DayMenuRepository extends JpaRepository<DayMenu, LocalDate> {}
