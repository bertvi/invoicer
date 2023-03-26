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
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id", "statusInfo"})
public class Customer {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String companyForm;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String regNo;
    @Column(nullable = false)
    private String vatNo;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String bankAccount;
    @Builder.Default
    @Embedded
    private StatusInfo statusInfo = new StatusInfo();
}
