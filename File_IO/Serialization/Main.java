package File_IO.Serialization;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException{
        Patient p1 = new Patient("Sathish", 1, 23, "Male",1234567890);
        Patient p2 = new Patient("Surendhar", 2, 23, "Male",1234567890);
        new Serializer().serialize(p1);
        new Serializer().serialize(p2);
        new Serializer().deSerialize();
        new Serializer().deSerialize();
    }
}