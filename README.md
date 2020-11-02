# ConcurentTask (2)
- 1.Реализовать метод вызова acceptTradeData и передачи ему объектов ExchangeOrder в параллельных потоках, количество потоков = количеству объектов ExchangeOrder
- 2.Написать метод обработки acceptTradeData, который будет обновлять входящие объекты ExchangeOrder по ID, выводить последнее валидное значение  объекта ExchangeOrder (like .toString()), валидным объектом считается объект, у которого
internalOrderId!=empty or null and exchangeOrderId!=empty or null , filledQty объектов может только увеличиваться и не может становиться меньше текущего значения
internalOrderId and exchangeOrderId уникальны в рамках 1 цикла работы данного приложения,
т.е.
