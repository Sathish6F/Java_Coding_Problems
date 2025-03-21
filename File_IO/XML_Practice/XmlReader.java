package File_IO.XML_Practice;
import java.io.IOException;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
public class XmlReader {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("///home/workspace/Test/src/File_IO/XML_Practice/Student.xml");
        Node root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        NodeList list = document.getElementsByTagName("student");
        for(int i = 0;i<list.getLength();i++){
            Node student = list.item(i);
            if(student.getNodeType() == Node.ELEMENT_NODE){
                Element st = (Element) student;

                String name = st.getElementsByTagName("name").item(0).getTextContent();
                String id = st.getElementsByTagName("id").item(0).getTextContent();
                String age = st.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("Student name: "+name);
                System.out.println("Student Id: "+id);
                System.out.println("Student Age: "+age);
                System.out.println("--------------------------");
            }
        }
        
    }
}