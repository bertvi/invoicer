package ee.solutionlab.invoicer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CustomerData {

    private String companyForm;
    private String name;
    private String regNo;
    private String vatNo;
    private String email;
    private String phone;
    private String address;
    private String country;
    private String bankAccount;
}
