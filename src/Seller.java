import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Seller {
    private Shop shop;
    public ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void receiveAuto() {
        try {
            lock.lock();
            System.out.println("производитель Тойота выпустил новый авто");
            Thread.sleep(1000);
            shop.getAuto().add(new Auto());
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized Auto sellAuto() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашёл в автосалон");
            while (shop.getAuto().isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " просит продать авто: машин нет");
                condition.await();
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return shop.getAuto().remove(0);
    }

}

