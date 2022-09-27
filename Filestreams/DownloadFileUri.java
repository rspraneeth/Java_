import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFileUri {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://filesamples.com/samples/document/txt/sample3.txt");
            File f = new File("Downld.txt");
            FileUtils.copyURLToFile(url, f);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}