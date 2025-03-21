package File_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	public static void main(String[] args) throws IOException{
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("///home/workspace/Test/src/File_IO/Prop.txt");
        p.load(fis);
        p.setProperty("Name", "Sathish");
        p.setProperty("Age", "23");
        FileOutputStream fos = new FileOutputStream("///home/workspace/Test/src/File_IO/Prop.txt",true);
        p.store(fos,"");
        System.out.println(p.getProperty("Age"));
        fis.close();
    }
}