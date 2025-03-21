package Numbers;

public class FindTrailingZeros {
    static int optimized(long n){
        int res=0;
        int pow=5;
        while(n>=pow){
            res+=(n/pow);
            pow*=5;
        }
        return res;
    }
    public static int trailingZeros(long n){
        n=fact(n);
        int count=0;
        while(n!=0){
            if(n%10==0){
                count++;
                n/=10;
            }
            else if(n%10!=0){
                return count;
            }
        }
        return count;
    }
    public static long fact(long n){
        if(n==0 || n==1) return 1;
        return n*fact(n-1);
    }
	public static void main(String[] args){
        int n=13;
        System.out.println(fact(n));
        System.out.println(trailingZeros(n));
        System.out.println(optimized(n));
    }
}