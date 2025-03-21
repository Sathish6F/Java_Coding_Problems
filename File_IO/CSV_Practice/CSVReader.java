package File_IO.CSV_Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
public class CSVReader {
	public static void main(String[] args)throws IOException{

        String fileName ="///home/workspace/Test/src/File_IO/CSV_Practice/Students.csv";
        File file = new File(fileName);

        TreeSet<Student> studentSet = new TreeSet<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        line = reader.readLine();
        try{
            while(line != null){
                String[] words = line.split(",");
                studentSet.add(new Student(words[0], Integer.parseInt(words[1]),Integer.parseInt(words[2])));
                line = reader.readLine();
            }
            Student.StudentsRankComparator(studentSet);
        }
        catch(NumberFormatException e){
            System.out.println("data Mismatched :"+line);
        }
        finally{
            reader.close();
        }
    }
}