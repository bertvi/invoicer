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
@Table(name = "unit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"id", "statusInfo"})
public class Unit {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Builder.Default
    @Embedded
    private StatusInfo statusInfo = new StatusInfo();
}
