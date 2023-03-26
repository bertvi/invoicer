package ee.solutionlab.invoicer.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id"})
public class Company {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_GEN")
    @SequenceGenerator(name = "COMPANY_GEN", sequenceName = "COMPANY_ID_SEQ", allocationSize = 1)
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
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime changed;
}
