import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.locks.Condition.*;

class Seller extends ReentrantLock {
    private AutoMarket autoMarket;
    Lock lock = new ReentrantLock();
    public Seller(AutoMarket autoMarket) {
        this.autoMarket = autoMarket;
    }
    public void receiveAuto() {
        try {
            lock.lock();
            System.out.println("Продавец: Тойота выпустила один авто");
            Thread.sleep(3000);
            autoMarket.getAuto().add(new Auto());
            System.out.println("Продавец: Авто пришел в салон");
            Condition.signal(); // Вместо notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public Auto sellAuto() {
        try {
            lock.lock();
            System.out.println("Продавец: отпускаю авто");
            while (autoMarket.getAuto().size() == 0) {
                System.out.println("Продавец: Не могу продать - машины нет!");
                Condition.await(); // Вместо wait();
            }
            Thread.sleep(1000);
            System.out.println("Продавец: авто продан");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return autoMarket.getAuto().remove(0);
    }
}
