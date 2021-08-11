import java.util.*;

class AutoMarket {
    // Продавец
    static Seller seller = new Seller(this);
    List<Auto> auto = new ArrayList<>(10);
    public Auto sellAuto() {
        return seller.sellAuto();
    }
    public static void acceptAuto() {
        seller.receiveAuto();
    }
    List<Auto> getAuto() {
        return auto;
    }
}
