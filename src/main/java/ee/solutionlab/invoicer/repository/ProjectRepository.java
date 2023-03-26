package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.name = :name")
    Optional<Project> findAnyByName(@Param("name") String name);

    @Query("SELECT p FROM Project p WHERE p.code = :code")
    Optional<Project> findAnyByCode(@Param("code") String code);

    @Query("SELECT p FROM Project p WHERE p.customer = :customer")
    Set<Project> findByCustomer(@Param("customer") Customer customer);
}
