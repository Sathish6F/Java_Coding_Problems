package File_IO.XOREncryption;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
        File src =  new File("///home/workspace/Test/src/File_IO/XOREncryption/Demo.txt");
        FileOutputStream fos = new FileOutputStream("///home/workspace/Test/src/File_IO/XOREncryption/EncryptedFile.txt");
        FileOutputStream fos2 = new FileOutputStream("///home/workspace/Test/src/File_IO/XOREncryption/Decrypted.txt");
        XorEncryption encryption = new XorEncryption('x');
        BufferedReader br = new BufferedReader(new FileReader(src));
        String line = br.readLine();
        while(line != null){
            String s = encryption.encrypt(line);
            fos.write(s.getBytes());
            line = br.readLine();
        }
        System.out.println("Encryption done");
        BufferedReader br1 = new BufferedReader(new FileReader("///home/workspace/Test/src/File_IO/XOREncryption/EncryptedFile.txt") );
        line = br1.readLine();
        while(line != null){
            String s = encryption.encrypt(line);
            fos2.write(s.getBytes());
            line = br1.readLine();
            fos2.write('\n');
        }
        fos2.write(new String("Shichan").getBytes());
        br.close();
        fos.close();
        br1.close();
        fos2.close();
    }
}