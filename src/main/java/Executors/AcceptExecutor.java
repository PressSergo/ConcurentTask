package Executors;

import acceptors.TradeAcceptor;
import domain.ExchangeOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AcceptExecutor {
    private final ExecutorService exOrder = Executors.newFixedThreadPool(15);
    private final List<Callable<ExchangeOrder>> task = new ArrayList<>(15);

    public void init() {
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("", "eID1", 0));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId1", "eID1", 10));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId2", "", 0));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId2", "eID2", 7));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId2", "", 10));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId3", "", 0));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("", "eID3", 10));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId3", "eID3", 8));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId4", "", 12));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("", "eID4", 10));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId4", "eID4", 8));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId5","",0));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("","eID5",10));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId5","eID5",8));
        });
        task.add(() -> {
            return TradeAcceptor.acceptTradeData(new ExchangeOrder("iId5","",17));
        });
    }

    public void start() throws InterruptedException {
        exOrder.invokeAll(task);
        exOrder.shutdown();
    }
}
