class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        new Thread(null, shop::sellAuto, "Покупатель1").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::sellAuto, "Покупатель2").start();
        new Thread(null, shop::sellAuto, "Покупатель3").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::sellAuto, "Покупатель4").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::sellAuto, "Покупатель5").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::sellAuto, "Покупатель6").start();
        new Thread(null, shop::sellAuto, "Покупатель7").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::sellAuto, "Покупатель8").start();
        new Thread(null, shop::sellAuto, "Покупатель9").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::acceptAuto, "производитель").start();
        new Thread(null, shop::sellAuto, "Покупатель10").start();
    }
}