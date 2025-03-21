package File_IO.XOREncryption;

public class XorEncryption {
    
    private char key;

    XorEncryption(char c){
        this.key = c;
    }

    public String encrypt(String s){
        StringBuffer sb = new StringBuffer();
        for(char c: s.toCharArray()){
            sb.append((char)(c ^ key));
        }
        return sb.toString();
    }

    public String decrypt(String s){
        StringBuffer sb = new StringBuffer();
        for(char c: s.toCharArray()){
            sb.append((char)(c ^ key));
        }
        return sb.toString();
    }
}