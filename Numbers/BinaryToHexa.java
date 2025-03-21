package Numbers;

public class BinaryToHexa {
    public static String toHexa(String s){
        int n=Integer.parseInt(toDecimal(s));
        StringBuffer sb=new StringBuffer();
        while(n>0){
            int r=n%16;
            if(r>9){
                sb.insert(0,(char)(r+55));
            }
            else{
                sb.insert(0,(char)(r+48));
            }
            n/=16;
        }
        return sb.toString();
    }
    public static String toDecimal(String s){
        int fact=1;
        StringBuilder sb=new StringBuilder();
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            res+=(s.charAt(i)-48)*fact;
            fact*=2;
        }
        return sb.append(res).toString();
    }
	public static void main(String[] args) {
        String binary="1010101110";
        System.out.println(binary+"="+toHexa(binary));
        System.out.println(binary+"="+toDecimal(binary));
    }
}