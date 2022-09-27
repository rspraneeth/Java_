import java.io.File;

public class FileDelOp {
    public static void main(String[] args) {
        File f = new File("asdfg.txt");
        if (f.exists()){
            boolean stat = f.delete();
            if (stat) System.out.println("Successfully deleted");
            else System.out.println("File not deleted");
        }
        else System.out.println("File doesn't exist");
    }
}
