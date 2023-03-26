package ee.solutionlab.invoicer.service;

import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Company;
import ee.solutionlab.invoicer.entity.Currency;
import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Invoice;
import ee.solutionlab.invoicer.entity.Price;
import ee.solutionlab.invoicer.entity.Project;
import ee.solutionlab.invoicer.entity.Unit;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Invoice getInvoice(String invoiceNo);

    Optional<Activity> getActivity(long id);

    Optional<Unit> getUnit(long id);

    Optional<Company> getCompany(long id);

    Optional<Customer> getCustomer(long id);

    Optional<Currency> getCurrency(long id);

    Optional<Invoice> getInvoice(long id);

    Optional<Price> getPrice(long id);

    Optional<Project> getProject(long id);

    List<Invoice> getInvoicesByCustomer(Customer customer);

    List<Invoice> getInvoicesByCompany(Company company);

    List<Invoice> getInvoicesByActivity(Activity activity);

    List<Activity> getActivities();

    List<Company> getCompanies();

    List<Currency> getCurrencies();

    List<Customer> getCustomers();

    List<Invoice> getInvoices();

    List<Price> getPrices();

    List<Unit> getUnits();

    List<Project> getProjects();

    Activity saveActivity(Activity activity);

    Company saveCompany(Company company);

    Currency saveCurrency(Currency currency);

    Customer saveCustomer(Customer customer);

    Invoice saveInvoice(Invoice invoice);

    Price savePrice(Price price);

    Unit saveUnit(Unit unit);

    Project saveProject(Project project);

    void deleteActivity(long id);

    void deleteUnit(long id);

    void deleteCompany(long id);

    void deleteCustomer(long id);

    void deleteCurrency(long id);

    void deleteInvoice(long id);

    void deletePrice(long id);

    void deleteProject(long id);
}
