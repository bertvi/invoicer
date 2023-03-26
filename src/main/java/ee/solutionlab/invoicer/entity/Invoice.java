package ee.solutionlab.invoicer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id", "statusInfo"})
public class Invoice {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String invoiceNo;
    @Column(nullable = false)
    private LocalDateTime dueDate;
    @Column(nullable = false)
    private float interestRate;
    @Column(nullable = false)
    private long quantity;
    @Column(nullable = false)
    private float amount;
    @Column(nullable = false)
    private float vatPercent;
    @Column(nullable = false)
    private float vatAmount;
    @Column(nullable = false)
    private float invoiceTotal;
    @ManyToOne
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "PRICE_ID")
    private Price price;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
    @Builder.Default
    @Embedded
    private StatusInfo statusInfo = new StatusInfo();
}
