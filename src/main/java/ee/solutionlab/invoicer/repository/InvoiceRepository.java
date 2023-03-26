package ee.solutionlab.invoicer.repository;

import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Company;
import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.Set;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Query("SELECT i FROM Invoice i WHERE i.invoiceNo = :invoiceNo")
    Optional<Invoice> findAnyByInvoiceNo(@Param("invoiceNo") String invoiceNo);

    @Query("SELECT i FROM Invoice i WHERE i.customer = :customer")
    Set<Invoice> findByCustomer(@Param("customer") Customer customer);

    @Query("SELECT i FROM Invoice i WHERE i.company = :company")
    Set<Invoice> findByCompany(@Param("company") Company company);

    @Query("SELECT i FROM Invoice i WHERE i.activity = :activity")
    Set<Invoice> findByActivity(@Param("activity") Activity activity);
}
