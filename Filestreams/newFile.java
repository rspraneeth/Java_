import java.io.File;
import java.io.IOException;

public class newFile {
    public static void main(String[] args) {
        File f = new File("asdfg.txt");
        if (f.exists())
            System.out.println("File exists");
        else{
            System.out.println("File doesn't exists");
            try {
                f.createNewFile();
                System.out.println("New file created");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        System.out.println("Length of file is "+f.length());

//        File f1 = new File("C:\\Users\\rspra\\Downloads\\zxc.txt");
//        try{
//            f1.createNewFile();
//            System.out.println("File created");
//        }catch (IOException e){
//            System.err.println("Not created");
//        }

        File f2 = new File("C:\\Users\\rspra\\Downloads");
        if (f2.isDirectory())
            System.out.println(f2.getName()+" is a folder");
        else
            System.out.println(f2.getName()+" is a file");
        File[] f2Arr = f2.listFiles();
        for (File fl: f2Arr) {
            System.out.println(fl.getName()+" is present inside "+f2.getName()+" with size "+fl.length());
        }
    }
}
