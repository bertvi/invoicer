package ee.solutionlab.invoicer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class InvoiceData {

    private String invoiceNo;
    private LocalDateTime dueDate;
    private float interestRate;
    private long quantity;
    private float amount;
    private float vatPercent;
    private float vatAmount;
    private float invoiceTotal;
    private UnitData unit;
    private PriceData price;
    private CustomerData customer;
    private CompanyData company;
    private ActivityData activity;
    private ProjectData project;
}
