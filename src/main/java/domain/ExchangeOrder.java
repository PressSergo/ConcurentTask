package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeOrder {
    private String internalOrderId;
    private String exchangeOrderId;
    private double filledQty;

    public ComposExchangeKey composeKey(){
        return new ComposExchangeKey(internalOrderId,exchangeOrderId);
    }
}
