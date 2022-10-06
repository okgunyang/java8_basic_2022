package sec2.confirm8;
//[ThreadExample.java]
public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();
        thread.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
        thread.interrupt();
    }
}
//[MovieThread.java]
class MovieThread extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i < 3; i++) {
            System.out.println("동영상을 재생합니다.");
            if (Thread.interrupted()) {
                break;
            }
        }
    }
}