import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileByteStreamEx {
    public static void main(String[] args) {
        File f = new File("myContacts.txt");
        String nameStr;
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            raf.writeBytes("Praneeth 9505193332");
            raf.writeBytes(System.lineSeparator());
            System.out.println("Data written to file");
//            while (raf.getFilePointer() < raf.length()){  // reading content in file
//                nameStr = raf.readLine();
//                System.out.println(nameStr);
//            }
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
