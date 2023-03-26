package ee.solutionlab.invoicer.controller;

import ee.solutionlab.invoicer.dto.ActivityData;
import ee.solutionlab.invoicer.dto.CompanyData;
import ee.solutionlab.invoicer.dto.CurrencyData;
import ee.solutionlab.invoicer.dto.CustomerData;
import ee.solutionlab.invoicer.dto.InvoiceData;
import ee.solutionlab.invoicer.dto.PriceData;
import ee.solutionlab.invoicer.dto.ProjectData;
import ee.solutionlab.invoicer.dto.UnitData;
import ee.solutionlab.invoicer.entity.Activity;
import ee.solutionlab.invoicer.entity.Company;
import ee.solutionlab.invoicer.entity.Currency;
import ee.solutionlab.invoicer.entity.Customer;
import ee.solutionlab.invoicer.entity.Invoice;
import ee.solutionlab.invoicer.entity.Price;
import ee.solutionlab.invoicer.entity.Project;
import ee.solutionlab.invoicer.entity.Unit;
import ee.solutionlab.invoicer.service.InvoiceService;
import ee.solutionlab.invoicer.util.InvoiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path = "/activities", produces = "application/json")
    public List<Activity> getActivities() {
        return invoiceService.getActivities();
    }

    @GetMapping("/activities/{id}")
    public Activity getActivity(@PathVariable Long id) {
        return invoiceService.getActivity(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/activities", produces = "application/json")
    public ResponseEntity createActivity(@RequestBody ActivityData activityData) throws URISyntaxException {
        Activity savedActivity = invoiceService.saveActivity(InvoiceUtil.createActivityFromData(activityData));
        return ResponseEntity.ok().body(savedActivity);
    }

    @PutMapping(path = "/activities", produces = "application/json")
    public ResponseEntity updateActivity(@PathVariable Long id, @RequestBody ActivityData activityData) {
        Activity currentActivity = invoiceService.getActivity(id).orElseThrow(RuntimeException::new);
        currentActivity.setName(activityData.getName());
        currentActivity.setChanged(LocalDateTime.now());
        currentActivity = invoiceService.saveActivity(currentActivity);
        return ResponseEntity.ok(currentActivity);
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity deleteActivity(@PathVariable Long id) {
        invoiceService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/companies", produces = "application/json")
    public List<Company> getCompanies() {
        return invoiceService.getCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company getCompany(@PathVariable Long id) {
        return invoiceService.getCompany(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/companies", produces = "application/json")
    public ResponseEntity createCompany(@RequestBody CompanyData companyData) throws URISyntaxException {
        Company savedCompany = invoiceService.saveCompany(InvoiceUtil.createCompanyFromData(companyData));
        return ResponseEntity.ok().body(savedCompany);
    }

    @PutMapping(path = "/companies", produces = "application/json")
    public ResponseEntity updateCompany(@PathVariable Long id, @RequestBody CompanyData companyData) {
        Company currentCompany = invoiceService.getCompany(id).orElseThrow(RuntimeException::new);
        currentCompany.setCompanyForm(companyData.getCompanyForm());
        currentCompany.setChanged(LocalDateTime.now());
        currentCompany.setName(companyData.getName());
        currentCompany.setCountry(companyData.getCountry());
        currentCompany.setAddress(companyData.getAddress());
        currentCompany.setEmail(companyData.getEmail());
        currentCompany.setPhone(companyData.getPhone());
        currentCompany.setBankAccount(companyData.getBankAccount());
        currentCompany.setVatNo(companyData.getVatNo());
        currentCompany.setRegNo(companyData.getRegNo());
        currentCompany = invoiceService.saveCompany(currentCompany);
        return ResponseEntity.ok(currentCompany);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity deleteCompany(@PathVariable Long id) {
        invoiceService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/currencies", produces = "application/json")
    public List<Currency> getCurrencies() {
        return invoiceService.getCurrencies();
    }

    @GetMapping("/currencies/{id}")
    public Currency getCurrency(@PathVariable Long id) {
        return invoiceService.getCurrency(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/currencies", produces = "application/json")
    public ResponseEntity createCurrency(@RequestBody CurrencyData currencyData) throws URISyntaxException {
        Currency savedCurrency = invoiceService.saveCurrency(InvoiceUtil.createCurrencyFromData(currencyData));
        return ResponseEntity.ok().body(savedCurrency);
    }

    @PutMapping(path = "/currencies", produces = "application/json")
    public ResponseEntity updateCurrency(@PathVariable Long id, @RequestBody CurrencyData currencyData) {
        Currency currentCurrency = invoiceService.getCurrency(id).orElseThrow(RuntimeException::new);
        currentCurrency.setName(currencyData.getName());
        currentCurrency.setChanged(LocalDateTime.now());
        currentCurrency = invoiceService.saveCurrency(currentCurrency);
        return ResponseEntity.ok(currentCurrency);
    }

    @DeleteMapping("/currencies/{id}")
    public ResponseEntity deleteCurrency(@PathVariable Long id) {
        invoiceService.deleteCurrency(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customer> getCustomers() {
        return invoiceService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return invoiceService.getCustomer(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/customers", produces = "application/json")
    public ResponseEntity createCustomer(@RequestBody CustomerData customerData) throws URISyntaxException {
        Customer savedCustomer = invoiceService.saveCustomer(InvoiceUtil.createCustomerFromData(customerData));
        return ResponseEntity.ok().body(savedCustomer);
    }

    @PutMapping(path = "/customers", produces = "application/json")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerData customerData) {
        Customer currentCustomer = invoiceService.getCustomer(id).orElseThrow(RuntimeException::new);
        currentCustomer.setCompanyForm(customerData.getCompanyForm());
        currentCustomer.setChanged(LocalDateTime.now());
        currentCustomer.setName(customerData.getName());
        currentCustomer.setCountry(customerData.getCountry());
        currentCustomer.setAddress(customerData.getAddress());
        currentCustomer.setEmail(customerData.getEmail());
        currentCustomer.setPhone(customerData.getPhone());
        currentCustomer.setBankAccount(customerData.getBankAccount());
        currentCustomer.setVatNo(customerData.getVatNo());
        currentCustomer.setRegNo(customerData.getRegNo());
        currentCustomer = invoiceService.saveCustomer(currentCustomer);
        return ResponseEntity.ok(currentCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        invoiceService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/invoices", produces = "application/json")
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping("/invoices/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return invoiceService.getInvoice(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/invoices", produces = "application/json")
    public ResponseEntity createInvoice(@RequestBody InvoiceData invoiceData) throws URISyntaxException {
        Invoice savedInvoice = invoiceService.saveInvoice(InvoiceUtil.createInvoiceFromData(invoiceData));
        return ResponseEntity.ok().body(savedInvoice);
    }

    @PutMapping(path = "/invoices", produces = "application/json")
    public ResponseEntity updateInvoice(@PathVariable Long id, @RequestBody InvoiceData invoiceData) {
        Invoice currentInvoice = invoiceService.getInvoice(id).orElseThrow(RuntimeException::new);
        currentInvoice.setActivity(InvoiceUtil.createActivityFromData(invoiceData.getActivity()));
        currentInvoice.setAmount(invoiceData.getAmount());
        currentInvoice.setCompany(InvoiceUtil.createCompanyFromData(invoiceData.getCompany()));
        currentInvoice.setCustomer(InvoiceUtil.createCustomerFromData(invoiceData.getCustomer()));
        currentInvoice.setInvoiceTotal(invoiceData.getInvoiceTotal());
        currentInvoice.setInvoiceNo(invoiceData.getInvoiceNo());
        currentInvoice.setPrice(InvoiceUtil.createPriceFromData(invoiceData.getPrice()));
        currentInvoice.setDueDate(invoiceData.getDueDate());
        currentInvoice.setInterestRate(invoiceData.getInterestRate());
        currentInvoice.setQuantity(invoiceData.getQuantity());
        currentInvoice.setUnit(InvoiceUtil.createUnitFromData(invoiceData.getUnit()));
        currentInvoice.setVatAmount(invoiceData.getVatAmount());
        currentInvoice.setVatPercent(invoiceData.getVatPercent());
        currentInvoice.setProject(InvoiceUtil.createProjectFromData(invoiceData.getProject()));
        currentInvoice.setChanged(LocalDateTime.now());
        currentInvoice = invoiceService.saveInvoice(currentInvoice);
        return ResponseEntity.ok(currentInvoice);
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/prices", produces = "application/json")
    public List<Price> getPrices() {
        return invoiceService.getPrices();
    }

    @GetMapping("/prices/{id}")
    public Price getPrice(@PathVariable Long id) {
        return invoiceService.getPrice(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/prices", produces = "application/json")
    public ResponseEntity createPrice(@RequestBody PriceData priceData) throws URISyntaxException {
        Price savedPrice = invoiceService.savePrice(InvoiceUtil.createPriceFromData(priceData));
        return ResponseEntity.ok().body(savedPrice);
    }

    @PutMapping(path = "/prices", produces = "application/json")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestBody PriceData priceData) {
        Price currentPrice = invoiceService.getPrice(id).orElseThrow(RuntimeException::new);
        currentPrice.setActivity(InvoiceUtil.createActivityFromData(priceData.getActivity()));
        currentPrice.setUnit(InvoiceUtil.createUnitFromData(priceData.getUnit()));
        currentPrice.setCurrency(InvoiceUtil.createCurrencyFromData(priceData.getCurrency()));
        currentPrice.setValue(priceData.getValue());
        currentPrice.setChanged(LocalDateTime.now());
        currentPrice = invoiceService.savePrice(currentPrice);
        return ResponseEntity.ok(currentPrice);
    }

    @DeleteMapping("/prices/{id}")
    public ResponseEntity deletePrice(@PathVariable Long id) {
        invoiceService.deletePrice(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/units", produces = "application/json")
    public List<Unit> getUnits() {
        return invoiceService.getUnits();
    }

    @GetMapping("/units/{id}")
    public Unit getUnit(@PathVariable Long id) {
        return invoiceService.getUnit(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/units", produces = "application/json")
    public ResponseEntity createUnit(@RequestBody UnitData unitData) throws URISyntaxException {
        Unit savedUnit = invoiceService.saveUnit(InvoiceUtil.createUnitFromData(unitData));
        return ResponseEntity.ok().body(savedUnit);
    }

    @PutMapping(path = "/units", produces = "application/json")
    public ResponseEntity updateUnit(@PathVariable Long id, @RequestBody UnitData unitData) {
        Unit currentUnit = invoiceService.getUnit(id).orElseThrow(RuntimeException::new);
        currentUnit.setName(unitData.getName());
        currentUnit.setValue(unitData.getValue());
        currentUnit.setChanged(LocalDateTime.now());
        currentUnit = invoiceService.saveUnit(currentUnit);
        return ResponseEntity.ok(currentUnit);
    }

    @DeleteMapping("/units/{id}")
    public ResponseEntity deleteUnit(@PathVariable Long id) {
        invoiceService.deleteUnit(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/projects", produces = "application/json")
    public List<Project> getProjects() {
        return invoiceService.getProjects();
    }


    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable Long id) {
        return invoiceService.getProject(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(path = "/projects", produces = "application/json")
    public ResponseEntity createProject(@RequestBody ProjectData projectData) throws URISyntaxException {
        Project savedProject = invoiceService.saveProject(InvoiceUtil.createProjectFromData(projectData));
        return ResponseEntity.ok().body(savedProject);
    }

    @PutMapping(path = "/projects", produces = "application/json")
    public ResponseEntity updateProject(@PathVariable Long id, @RequestBody ProjectData projectData) {
        Project currentProject = invoiceService.getProject(id).orElseThrow(RuntimeException::new);
        currentProject.setName(projectData.getName());
        currentProject.setCode(projectData.getCode());
        currentProject.setCustomer(InvoiceUtil.createCustomerFromData(projectData.getCustomer()));
        currentProject.setChanged(LocalDateTime.now());
        currentProject = invoiceService.saveProject(currentProject);
        return ResponseEntity.ok(currentProject);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        invoiceService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
