package File_IO.XML_Practice;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Student implements Comparable,Serializable {
    @XmlElement
	String name;
    @XmlElement
    int id;
    @XmlElement
    int age;
    Student(){}
    Student(String name,int id,int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String toString(){
        return "Id "+this.id+" - "+this.name;
    }

   
    public int compareTo(Object o) {
        Student s = (Student)o;
        return Integer.compare(this.id, s.id);
    }

    
}