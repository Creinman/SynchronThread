class Main {
    /*public static void main(String[] args) {
        final Shop shop = new Shop();
// Покупатель, чья работа заключается в том, чтобы купить хлеб - shop.sellBread()
        new Thread(null, shop::sellBread, "Покупатель").start();
// Водитель хлебопекарни, чья работа заключается в том, чтобы привезти хлеб - shop.acceptBread()
        new Thread(null, shop::acceptBread, "Водитель хлебопекарни").start();
    }*/

    public static void main(String[] args) throws InterruptedException {
        final Shop shop = new Shop();
// Идем за покупками
        Runnable shopping = shop::buySomething;
        new Thread(null, shopping, "Покупатель 1").start();
        new Thread(null, shopping, "Покупатель 2").start();
        new Thread(null, shopping, "Покупатель 3").start();
    }
}