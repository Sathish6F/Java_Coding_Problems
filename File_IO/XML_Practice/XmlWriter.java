package File_IO.XML_Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlWriter {
	public static void main(String[] args) throws JAXBException, IOException{

        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        Student s = new Student("Jeya", 2036, 24);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(s,new FileWriter(new File("///home/workspace/Test/src/File_IO/XML_Practice/Student.xml"),true));
        System.out.println("Written....");
        
    }
}