package Numbers;

public class RightMostSetBit {
    static int positionOfRmsb(int n){
        int mask = 1;
        int pos = 1;
        if(n == 0){
            return -1;
        }
        while((n & mask) == 0){
            mask = mask << 1;
            pos++;
        }
        return pos;
    }
    static int optimized(int n){
        if(n==0) return -1;
        return (int)((Math.log10(n ^ (n & (n-1))))/Math.log10(2))+1;
    }
	public static void main(String[] args){
        int n=2;
        System.out.println(positionOfRmsb(n));
        System.out.println(optimized(n));
    }
}