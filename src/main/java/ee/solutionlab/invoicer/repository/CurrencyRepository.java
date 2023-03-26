package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    @Query("SELECT c FROM Currency c WHERE c.name = :name")
    Optional<Currency> findAnyByName(@Param("name") String name);

}
