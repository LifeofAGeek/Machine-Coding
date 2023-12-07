public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
