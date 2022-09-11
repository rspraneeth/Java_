public class ThreadMain {
    public static void main(String[] args) {
        ThreadNewExample te = new ThreadNewExample();
        ThreadNewExample te1 = new ThreadNewExample();
        RunnableThreadExample rte = new RunnableThreadExample();
        Thread t = new Thread(rte, "naming as runnable thread");
        System.out.println(te.getName() + " " + te1.getName());
        System.out.println(t.getState() + " " + t.getName());
        t.start();
        te.start();
        te1.start();
        System.out.println("Started in main method");
        for (int i = 0; i < 10; i++)
            System.out.println("Main " + i);
        System.out.println("Ended in main method");
    }
}
