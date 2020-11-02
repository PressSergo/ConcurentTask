package acceptors;

import domain.ComposExchangeKey;
import domain.ExchangeOrder;
import lombok.extern.java.Log;

import java.util.concurrent.ConcurrentHashMap;

@Log
public class TradeAcceptor {
    private final static ConcurrentHashMap<ComposExchangeKey, ExchangeOrder> validObjects= new ConcurrentHashMap<>();

    public static  <T extends ExchangeOrder> T acceptTradeData(T tradeObject){
        if (tradeObject.getExchangeOrderId().equals("") || tradeObject.getInternalOrderId().equals("")){
            updateID(tradeObject);
        }
        ComposExchangeKey composExchangeKey = tradeObject.composeKey();
        ExchangeOrder exchangeOrder = validObjects.get(composExchangeKey);
        if (exchangeOrder != null && tradeObject.getFilledQty() >=0){
            incFilledQty(exchangeOrder,tradeObject);
        }else{
            validObjects.put(composExchangeKey,tradeObject);
        }

        log.info(validObjects.get(composExchangeKey).toString());

        return tradeObject;
    }

    private static void updateID(ExchangeOrder exchangeOrder){
        if (exchangeOrder.getExchangeOrderId().equals("")){
            exchangeOrder.setExchangeOrderId("eID"+exchangeOrder.getInternalOrderId()
                    .substring(exchangeOrder.getInternalOrderId().length()-1));
        }else{
            exchangeOrder.setInternalOrderId("iId"+exchangeOrder.getExchangeOrderId()
                    .substring(exchangeOrder.getExchangeOrderId().length()-1));
        }
    }

    private static void incFilledQty(ExchangeOrder tmp1, ExchangeOrder tmp2){
        tmp1.setFilledQty(tmp1.getFilledQty()+tmp2.getFilledQty());
    }
}
