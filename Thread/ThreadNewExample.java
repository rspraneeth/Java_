public class ThreadNewExample extends Thread{
    @Override
    public void run(){
        System.out.println("Thread new started");
        for (int i = 0; i < 10; i++)
            System.out.println("Thread "+i);
        System.out.println("Thread new stopped");
    }
}
