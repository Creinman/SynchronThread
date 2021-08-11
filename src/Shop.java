import java.util.*;

class Shop {
    Seller seller = new Seller(this);
    List<Auto> autos = new ArrayList<>(10);

    public Auto sellAuto() {
        return seller.sellAuto();
    }

    public void acceptAuto() {
        seller.receiveAuto();
    }

    List<Auto> getAuto() {
        return autos;
    }
}