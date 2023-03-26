package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Unit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit, Long> {

    @Query("SELECT u FROM Unit u WHERE u.name = :name")
    Optional<Unit> findAnyByName(@Param("name") String name);

}
