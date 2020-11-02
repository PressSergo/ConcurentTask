package domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ComposExchangeKey {
    private String internalOrderId;
    private String exchangeOrderId;
}
