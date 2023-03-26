package ee.solutionlab.invoicer.controller;

import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Company;
import ee.solutionlab.invoicer.entity.Currency;
import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Invoice;
import ee.solutionlab.invoicer.entity.Price;
import ee.solutionlab.invoicer.entity.Unit;
import ee.solutionlab.invoicer.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path = "/heartbeat", produces = "application/json")
    public String getHeartbeat() {
        return "Hello World!";
    }

    @GetMapping(path = "/activities", produces = "application/json")
    public List<Activity> getActivities() {
        return invoiceService.getActivities();
    }

    @GetMapping(path = "/companies", produces = "application/json")
    public List<Company> getCompanies() {
        return invoiceService.getCompanies();
    }

    @GetMapping(path = "/currencies", produces = "application/json")
    public List<Currency> getCurrencies() {
        return invoiceService.getCurrencies();
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customer> getCustomers() {
        return invoiceService.getCustomers();
    }

    @GetMapping(path = "/invoices", produces = "application/json")
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping(path = "/prices", produces = "application/json")
    public List<Price> getPrices() {
        return invoiceService.getPrices();
    }

    @GetMapping(path = "/units", produces = "application/json")
    public List<Unit> getUnits() {
        return invoiceService.getUnits();
    }

    @PostMapping(path = "/create_activity", produces = "application/json")
    public ResponseEntity createActivity(@RequestBody Activity activity) throws URISyntaxException {
        Activity savedActivity = invoiceService.saveActivity(activity);
        return ResponseEntity.ok().body(savedActivity);
    }

    @PostMapping(path = "/create_company", produces = "application/json")
    public ResponseEntity createCompany(@RequestBody Company company) throws URISyntaxException {
        Company savedCompany = invoiceService.saveCompany(company);
        return ResponseEntity.ok().body(savedCompany);
    }

    @PostMapping(path = "/create_currency", produces = "application/json")
    public ResponseEntity createCurrency(@RequestBody Currency currency) throws URISyntaxException {
        Currency savedCurrency = invoiceService.saveCurrency(currency);
        return ResponseEntity.ok().body(savedCurrency);
    }

    @PostMapping(path = "/create_customer", produces = "application/json")
    public ResponseEntity createCustomer(@RequestBody Customer customer) throws URISyntaxException {
        Customer savedCustomer = invoiceService.saveCustomer(customer);
        return ResponseEntity.ok().body(savedCustomer);
    }

    @PostMapping(path = "/create_invoice", produces = "application/json")
    public ResponseEntity createInvoice(@RequestBody Invoice invoice) throws URISyntaxException {
        Invoice savedInvoice = invoiceService.saveInvoice(invoice);
        return ResponseEntity.ok().body(savedInvoice);
    }

    @PostMapping(path = "/create_price", produces = "application/json")
    public ResponseEntity createPrice(@RequestBody Price price) throws URISyntaxException {
        Price savedPrice = invoiceService.savePrice(price);
        return ResponseEntity.ok().body(savedPrice);
    }

    @PostMapping(path = "/create_unit", produces = "application/json")
    public ResponseEntity createUnit(@RequestBody Unit unit) throws URISyntaxException {
        Unit savedUnit = invoiceService.saveUnit(unit);
        return ResponseEntity.ok().body(savedUnit);
    }
}
