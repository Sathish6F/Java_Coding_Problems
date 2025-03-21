package Numbers;
// count no.of trailing zeros in a binary representation of a number
public class TrailingZerosInBinary {
    static int trailingZeros(int n){
        return (int) (Math.log10((n & (n-1))^ n)/Math.log10(2));
    }
	public static void main(String[] args){
        int n=128;
        System.out.println(trailingZeros(n));
    }
}