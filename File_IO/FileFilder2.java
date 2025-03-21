package File_IO;
import java.io.*;
public class FileFilder2 {
    static int cnt = 0;
	public static void main(String[] args){
        File source = new File("///home/workspace/Test");
        File target = new File("Sample.txt");
        System.out.println(System.currentTimeMillis()/1000);
        fileFounder(source,target,false);
    }
    static void fileFounder(File src,File t,boolean found){
        cnt++;
        File[] list = src.listFiles();
        for(File f:list){
            if(f.isDirectory()){
                fileFounder(f, t,found);
            }
            if(f.isFile() && f.getName().equals(t.getName())){
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("Found at count "+ cnt+": "+t.getAbsolutePath());
            System.out.println(System.currentTimeMillis()/1000);
            return;
        }
    }
}