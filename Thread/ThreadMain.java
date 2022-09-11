public class ThreadMain {
    public static void main(String[] args) {
        ThreadNewExample te = new ThreadNewExample();
        ThreadNewExample te1 = new ThreadNewExample();
        ThreadNewExample te2 = new ThreadNewExample();
        te.start();
        te1.start();
        te2.start();
        System.out.println("Started in main method");
        for (int i = 0; i < 10; i++)
            System.out.println("Main "+i);
        System.out.println("Ended in main method");
    }
}
