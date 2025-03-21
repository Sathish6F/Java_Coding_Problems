package Numbers;

public class PrimeuptoN {
    //Eratosthenes Algorithm O(-/nlog(log(n)))-> O(n*_/n)
    static void printPrime(int n){
        boolean[] prime = new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            if(prime[i]==false){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=true;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(prime[i]==false){
                System.out.println(i);
            }
        }
    }
	public static void main(String[] args){
        int n=50;
        printPrime(n);
    }
}