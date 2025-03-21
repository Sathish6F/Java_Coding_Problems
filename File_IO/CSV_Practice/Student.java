package File_IO.CSV_Practice;

import java.util.Comparator;
import java.util.TreeSet;

public class Student implements Comparable<Student>{
	public String name;
    public int id;
    public int totalMarks;

    static Comparator<Student> rankComparator = new Comparator<Student>()
    {
        public int compare(Student s1, Student s2) 
        {
            return Integer.compare(s2.totalMarks,s1.totalMarks);
        }
    };

    public Student(String name,int id,int totalMarks){
        this.name = name;
        this.id = id;
        this.totalMarks = totalMarks;
    }

    public static void StudentsRankComparator(TreeSet<Student> studentSet){
        TreeSet<Student> rankSet = new TreeSet<>(Student.rankComparator);
        for(Student s : studentSet){
            rankSet.add(s);
        }
        System.out.println("In Rank Order:");
        for(Student s: rankSet){
            System.out.println(s);
        }
    }
    
    public int compareTo(Student s) {
       return Integer.compare(this.id, s.id);
    }

    public String toString(){
        return this.id+"\t"+this.name+"\t"+this.totalMarks;
    }

}