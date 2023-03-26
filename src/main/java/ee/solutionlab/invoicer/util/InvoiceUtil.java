package ee.solutionlab.invoicer.util;

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

import java.time.LocalDateTime;

public class InvoiceUtil {

    private InvoiceUtil() {}

    public static Activity createActivityFromData(ActivityData activityData) {
        return Activity.builder()
                .name(activityData.getName())
                .created(LocalDateTime.now())
                .changed(LocalDateTime.now())
                .build();
    }

    public static Company createCompanyFromData(CompanyData companyData) {
        return Company.builder()
                .companyForm(companyData.getCompanyForm())
                .address(companyData.getAddress())
                .phone(companyData.getPhone())
                .regNo(companyData.getRegNo())
                .bankAccount(companyData.getBankAccount())
                .vatNo(companyData.getVatNo())
                .email(companyData.getEmail())
                .country(companyData.getCountry())
                .name(companyData.getName())
                .created(LocalDateTime.now())
                .changed(LocalDateTime.now())
                .build();
    }

    public static Currency createCurrencyFromData(CurrencyData currencyData) {
        return Currency.builder()
                .name(currencyData.getName())
                .created(LocalDateTime.now())
                .changed(LocalDateTime.now())
                .build();
    }

    public static Customer createCustomerFromData(CustomerData customerData) {
        return Customer.builder()
                .companyForm(customerData.getCompanyForm())
                .address(customerData.getAddress())
                .phone(customerData.getPhone())
                .regNo(customerData.getRegNo())
                .bankAccount(customerData.getBankAccount())
                .vatNo(customerData.getVatNo())
                .email(customerData.getEmail())
                .country(customerData.getCountry())
                .name(customerData.getName())
                .created(LocalDateTime.now())
                .changed(LocalDateTime.now())
                .build();
    }

    public static Invoice createInvoiceFromData(InvoiceData invoiceData) {
        return Invoice.builder()
                .invoiceNo(invoiceData.getInvoiceNo())
                .invoiceTotal(invoiceData.getInvoiceTotal())
                .dueDate(invoiceData.getDueDate())
                .interestRate(invoiceData.getInterestRate())
                .amount(invoiceData.getAmount())
                .quantity(invoiceData.getQuantity())
                .vatAmount(invoiceData.getVatAmount())
                .vatPercent(invoiceData.getVatPercent())
                .activity(createActivityFromData(invoiceData.getActivity()))
                .company(createCompanyFromData(invoiceData.getCompany()))
                .customer(createCustomerFromData(invoiceData.getCustomer()))
                .price(createPriceFromData(invoiceData.getPrice()))
                .unit(createUnitFromData(invoiceData.getUnit()))
                .project(Project.builder()
                        .name(invoiceData.getProject().getName())
                        .code(invoiceData.getProject().getCode())
                        .customer(createCustomerFromData(invoiceData.getProject().getCustomer()))
                        .created(LocalDateTime.now())
                        .changed(LocalDateTime.now())
                        .build())
                .build();
    }

    public static Price createPriceFromData(PriceData priceData) {
        return Price.builder()
                .value(priceData.getValue())
                .activity(createActivityFromData(priceData.getActivity()))
                .currency(createCurrencyFromData(priceData.getCurrency()))
                .unit(createUnitFromData(priceData.getUnit()))
                .build();
    }

    public static Unit createUnitFromData(UnitData unitData) {
        return Unit.builder()
                .name(unitData.getName())
                .value(unitData.getValue())
                .created(LocalDateTime.now())
                .changed(LocalDateTime.now())
                .build();
    }

    public static Project createProjectFromData(ProjectData projectData) {
        return Project.builder()
                .name(projectData.getName())
                .code(projectData.getCode())
                .customer(createCustomerFromData(projectData.getCustomer()))
                .created(LocalDateTime.now())
                .changed(LocalDateTime.now())
                .build();
    }
}
