package File_IO;
import java.io.*;
public class FisFos {
    //read the data from the keyboard and write it to the file 
	public static void main(String[] args)throws IOException{
        File f = new File("Sample.txt");
        File t = new File("Sample1.txt");
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(System.in);
        FileOutputStream fos = new FileOutputStream(f,true);
        System.out.println("Enter the text (* at end)");
        int c;
        while((c=dis.read())!='*'){
            fos.write((char)c);
        }
        fos.flush();
        byte[] b = new byte[(int)f.length()];
        fis.read(b);
        for(byte br: b){
            System.out.print((char)br);
        }
        copyFile(f, t);
        fis.close();
        fos.close();
        dis.close();

    }
    public static void copyFile(File from,File to){
        try {
            FileInputStream fis = new FileInputStream(from);
            FileOutputStream fos = new FileOutputStream(to);

            byte[] b = new byte[(int)from.length()];
            fis.read(b);
            fos.write(b);
            fis.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}