package Numbers;

public class PowOfTwo {
    static boolean isPowOf2(int n){
        if(n == 0){
            return false;
        }
        return (n & (n-1))==0;
    }
	public static void main(String[] args){
        int n=128;
        System.out.println(n+"---"+isPowOf2(n));
    }
}