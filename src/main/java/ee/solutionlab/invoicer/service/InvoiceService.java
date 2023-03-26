package ee.solutionlab.invoicer.service;

import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Company;
import ee.solutionlab.invoicer.entity.Currency;
import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Invoice;
import ee.solutionlab.invoicer.entity.Price;
import ee.solutionlab.invoicer.entity.Unit;

import java.util.List;

public interface InvoiceService {

    Invoice getInvoice(String invoiceNo);

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

    Activity saveActivity(Activity activity);

    Company saveCompany(Company company);

    Currency saveCurrency(Currency currency);

    Customer saveCustomer(Customer customer);

    Invoice saveInvoice(Invoice invoice);

    Price savePrice(Price price);

    Unit saveUnit(Unit unit);

}
