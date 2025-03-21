package File_IO;
import java.io.*;
import java.util.*;
public class CountOccurence {
	public static void main(String[] args) throws IOException{
        File f = new File("Sample.txt");
        Map<String,Integer> wordMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = br.readLine();
        while(line != null){
            String[] words = line.toLowerCase().split("\\W+");
            for(String word:words){
                if(!word.isEmpty()){
                    wordMap.put(word,wordMap.getOrDefault(word, 0)+1);
                }
            }
            line = br.readLine();
        }
        br.close();
        for(Map.Entry e: wordMap.entrySet()){
            System.out.println(e.getKey()+"-"+e.getValue());
        }
    }
}