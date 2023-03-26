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
public class PriceData {

    private long value;
    private UnitData unit;
    private ActivityData activity;
    private CurrencyData currency;
}
