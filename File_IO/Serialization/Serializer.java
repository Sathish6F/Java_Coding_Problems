package File_IO.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
    public void serialize(Patient p){
        try{
            FileOutputStream fos = new FileOutputStream("///home/workspace/Test/src/File_IO/Serialization/PateintData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            System.out.println("Object Serialized...");
            oos.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        } 
    }

    public void deSerialize() throws ClassNotFoundException{
        try{
            FileInputStream fis = new FileInputStream("///home/workspace/Test/src/File_IO/Serialization/PateintData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Patient p = (Patient) ois.readObject();
            System.out.println("Deserialized.....");
            System.out.println(p.name);
            System.out.println(p.age);
            System.out.println(p.gender);
            System.out.println(p.mobileNo);
            ois.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}