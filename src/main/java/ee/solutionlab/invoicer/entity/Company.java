package ee.solutionlab.invoicer.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id", "statusInfo"})
public class Company {

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
