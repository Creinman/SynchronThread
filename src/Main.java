class Main {
    public static void main(String[] args) throws InterruptedException {
        final AutoMarket autoMarket = new AutoMarket();
        new Thread(null, autoMarket::sellAuto, "Покупатель").start();
        new Thread(null, AutoMarket::acceptAuto, "получение авто").start();
    }
}