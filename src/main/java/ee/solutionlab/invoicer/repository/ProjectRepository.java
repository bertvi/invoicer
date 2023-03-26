package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Activity, Long> {

    @Query("SELECT a FROM Activity a WHERE a.name = :name")
    Optional<Activity> findAnyByName(@Param("name") String name);

}
