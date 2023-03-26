package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.activity = :activity")
    Optional<Price> findAnyByActivity(@Param("activity") Activity activity);

}
