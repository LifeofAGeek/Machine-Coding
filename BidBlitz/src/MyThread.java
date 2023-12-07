public class MyThread extends Thread{
    public MyThread(MyRunnable myRunnable) {
    }

    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}
