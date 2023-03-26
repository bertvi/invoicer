package ee.solutionlab.invoicer.service;

import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Company;
import ee.solutionlab.invoicer.entity.Currency;
import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Invoice;
import ee.solutionlab.invoicer.entity.Price;
import ee.solutionlab.invoicer.entity.Unit;
import ee.solutionlab.invoicer.repository.ActivityRepository;
import ee.solutionlab.invoicer.repository.CompanyRepository;
import ee.solutionlab.invoicer.repository.CurrencyRepository;
import ee.solutionlab.invoicer.repository.CustomerRepository;
import ee.solutionlab.invoicer.repository.InvoiceRepository;
import ee.solutionlab.invoicer.repository.PriceRepository;
import ee.solutionlab.invoicer.repository.UnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component("catalogService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    UnitRepository unitRepository;

    @Override
    public Invoice getInvoice(String invoiceNo) {
        return null;
    }

    @Override
    public List<Invoice> getInvoicesByCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Invoice> getInvoicesByCompany(Company company) {
        return null;
    }

    @Override
    public List<Invoice> getInvoicesByActivity(Activity activity) {
        return null;
    }

    @Override
    public List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();
        activityRepository.findAll().forEach(activities::add);
        return activities;
    }

    @Override
    public List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }

    @Override
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        currencyRepository.findAll().forEach(currencies::add);
        return currencies;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public List<Invoice> getInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoices::add);
        return invoices;
    }

    @Override
    public List<Price> getPrices() {
        List<Price> prices = new ArrayList<>();
        priceRepository.findAll().forEach(prices::add);
        return prices;
    }

    @Override
    public List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>();
        unitRepository.findAll().forEach(units::add);
        return units;
    }

    @Override
    public Activity saveActivity(Activity activity) { return null;}

    @Override
    public Company saveCompany(Company company) { return null;}

    @Override
    public Currency saveCurrency(Currency currency) { return null;}

    @Override
    public Customer saveCustomer(Customer customer) { return null;}

    @Override
    public Invoice saveInvoice(Invoice invoice) { return null;}

    @Override
    public Price savePrice(Price price) { return null;}

    @Override
    public Unit saveUnit(Unit unit) { return null;}

}
