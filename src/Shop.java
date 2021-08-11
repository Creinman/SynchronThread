import java.util.*;

class Shop {
    // Продавец
    Seller seller = new Seller(this);
    List<Bread> breads = new ArrayList<>(10);
    public Bread sellBread() {
        return seller.sellBread();
    }
    public void acceptBread() {
        seller.receiveBread();
    }
    List<Bread> getBreads() {
        return breads;
    }
    
    public void buySomething() {
// Критическая секция
        synchronized (seller) {
            System.out.println(Thread.currentThread().getName() + " покупает");
// Процесс покупки. Эмулируем, приостанавливая поток
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " пошел домой");
        }
    }
}