package Numbers;

public class HexaToBinary {
    public static String toBinary(String s){
        String decimal=toDecimal(s);
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(decimal);
        while(n>0){
            sb.insert(0,(n%2));
            n/=2;
        }
        return sb.toString();
    }
    public static String toDecimal(String s){
        StringBuilder sb=new StringBuilder();
        int fact=1;
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)>='A' && s.charAt(i)<='F'){
                res=(res)+((s.charAt(i)-55)*fact);
                fact*=16;
            }
            else{
               res=(res)+((s.charAt(i)-48)*fact);
                fact*=16;
            }
        }
        return sb.append(res).toString();
    }
	public static void main(String[] args){
        String s="2AEFB";
        System.out.println(s+"="+toBinary(s));
    }
}