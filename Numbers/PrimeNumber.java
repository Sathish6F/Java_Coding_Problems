package Numbers;

public class PrimeNumber {
    public static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean checkPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;

        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args){
        int n=35;
        System.out.println(n);
        System.out.println(isPrime(n));
        System.out.println(checkPrime(n));
    }
}