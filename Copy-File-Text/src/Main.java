
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("source.txt");
            fileWriter = new FileWriter("target.txt");
            int ch;
            while ((ch = fileReader.read()) != -1){
                fileWriter.write((char)ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fileWriter!=null){
                fileWriter.close();
            }
            if(fileReader!=null){
                fileReader.close();
            }
        }
    }
}