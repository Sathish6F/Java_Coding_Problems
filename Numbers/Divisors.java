package Numbers;

public class Divisors {
    static void printDivisors(int n){
        int i=0;
        for(i=1;i*i<=n;i++){
            if(n%i==0){
                System.out.println(i);
            }  
        }
        for(;i>=1;i--){
            if((n%i)==0 && (n/i)!=i){
                System.out.println(n/i);
            }
        }
    }
	public static void main(String[] args){
        int n=100;
        printDivisors(n);
    }
}