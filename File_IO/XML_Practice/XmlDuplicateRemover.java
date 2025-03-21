package File_IO.XML_Practice;

import java.io.IOException;
import java.util.TreeMap;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XmlDuplicateRemover {
	
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse("///home/workspace/Test/src/File_IO/XML_Practice/Student.xml");
        
        NodeList list = doc.getElementsByTagName("student");
        TreeMap<Integer,Student> map = new TreeMap<>();

        for(int i = 0;i<list.getLength();i++){
            Node node = list.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element student = (Element) node;

                String name = student.getElementsByTagName("name").item(0).getTextContent();
                String id = student.getElementsByTagName("id").item(0).getTextContent();
                String age = student.getElementsByTagName("age").item(0).getTextContent();

                Student s = new Student(name, Integer.parseInt(id),Integer.parseInt(age));
                map.put(Integer.parseInt(id), s);
            }
        }
        
        System.out.println(map.values());

    }
   
        

}