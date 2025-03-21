package File_IO;
import java.io.*;
public class WordCnt {
	public static void main(String[] args) throws IOException{
        File f=new File("README.md");
        BufferedReader br=new BufferedReader(new FileReader(f));
        int wordcnt=0;
        String line=br.readLine();
        while(line!=null){
            wordcnt++;
            line=br.readLine();
        }
        System.out.println("The total no.of lines:"+wordcnt);
    } 
}