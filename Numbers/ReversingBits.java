package Numbers;
// reverse all the bits in a binay format of a number
public class ReversingBits {
    static int reverseBits(int n){
        if(n==0) return 0;
        int f=31,l=0;
        int rev=0;
        while(f>l){

            if((n & (1<<f)) != 0){
                rev= rev |(1<<l);
            }
            if((n & (1<<l)) != 0){
                rev = rev | (1<<f);
            }
            f--;
            l++;
        }
        return rev;
    }
	public static void main(String[] args){
        int n=0;
        System.out.println(reverseBits(n));
    }
}