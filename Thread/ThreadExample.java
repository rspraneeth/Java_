public class ThreadExample extends Thread {
    @Override
    public void run(){
        System.out.println("Thread started, and in run method");
    }
    public static void main(String[] args) {
        ThreadExample te = new ThreadExample();
        te.start();
    }
}
