package File_IO;
import java.io.*;
public class FileFinder {

	public static void main(String[] args){

        File file = new File("///home/workspace/Test");
        File target = new File("Sample.txt");
        File[] list = file.listFiles();
        FileThread.f1 = target;
        System.out.println((System.currentTimeMillis()/1000));
        for(File f : list){
            if(f.isDirectory()){
                FileThread t = new FileThread();
                t.toStart = f;
                t.start();
            }
            else if(f.isFile()){
                if(f.getName().equals(target.getName())){
                    System.out.println("File Found at:"+f.getAbsolutePath());
                    break;
                }
            }
        }
        System.out.println((System.currentTimeMillis()/1000));

    }
}
class FileThread extends Thread{
    static File f1;
    static int tnumber = 1;
    File toStart;
    FileThread(){
        tnumber++;
    }
    public void run(){
        File[] list = toStart.listFiles();
        for(File f : list){
            if(f.isDirectory()){
                FileThread t = new FileThread();
                t.toStart = f;
                t.start();
            }
            if(f.isFile()){
                if(f.getName().equals(f1.getName())){
                    System.out.println("File Found by Thread"+tnumber+" at:"+f.getAbsolutePath());
                    System.exit(0);
                }
            }
        }
    }
}