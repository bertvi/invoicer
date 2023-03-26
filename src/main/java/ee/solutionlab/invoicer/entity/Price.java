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

@Entity
@Table(name = "price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id", "statusInfo"})
public class Price {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private long value;
    @OneToOne
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
    @OneToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
    @Builder.Default
    @Embedded
    private StatusInfo statusInfo = new StatusInfo();
}
