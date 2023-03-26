package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.country = :country")
    Optional<Customer> findAnyByCountry(@Param("country") String country);

    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    Optional<Customer> findAnyByName(@Param("name") String name);

    @Query("SELECT c FROM Customer c WHERE c.regNo = :regNo")
    Optional<Customer> findAnyByRegNo(@Param("regNo") String regNo);
}
