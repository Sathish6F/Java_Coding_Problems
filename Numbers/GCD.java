package Numbers;

public class GCD {
    //Euclids Algorithm
    public static int gcd(int a,int b){
        while(a!=0 && b!=0){
            if(a>b){
                a=a%b;
            }else{
                b=b%a;
            }
            
        }
        if(a!=0){
          return a;
        }
        return b;
    }
	public static void main(String[] args){
        int a=33,b=75;
        System.out.println(gcd(a,b));
    }
}