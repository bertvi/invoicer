package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE c.country = :country")
    Optional<Company> findAnyByCountry(@Param("country") String country);

    @Query("SELECT c FROM Company c WHERE c.name = :name")
    Optional<Company> findAnyByName(@Param("name") String name);

    @Query("SELECT c FROM Company c WHERE c.regNo = :regNo")
    Optional<Company> findAnyByRegNo(@Param("regNo") String regNo);
}
