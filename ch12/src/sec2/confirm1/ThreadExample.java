package sec2.confirm1;
//[ThreadExample.java]
public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new MovieThread();
        thread1.start();
        
        Thread thread2 = new Thread(new MusicRunnable());
        thread2.start();
    }
}
//[MovieThread.java]
class MovieThread extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i < 3; i++) {
            System.out.println("동영상을 재생합니다.");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
//[MusicRunnable.java]
class MusicRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0 ; i < 3;i++) {
            System.out.println("음악을 재생합니다.");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}