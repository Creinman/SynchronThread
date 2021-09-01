class Seller {
    private Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void receiveAuto() {
        System.out.println("производитель Тойота выпустил новый авто");
        shop.getAuto().add(new Auto());
        notifyAll();
    }

    public synchronized Auto sellAuto() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашёл в автосалон");
            //while (shop.getAuto().size() == 0) {
            while (shop.getAuto().isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " просит продать авто: машин нет");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shop.getAuto().remove(0);
    }

}

