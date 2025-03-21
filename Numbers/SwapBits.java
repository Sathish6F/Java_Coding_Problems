package Numbers;
// swap odd position bits to even position ans vice versa
public class SwapBits {
    static int swapBits(int n){
        return ((n & 0xaaaaaaaa)>>>1) | ((n & 0x55555555)<<1);
    }
	public static void main(String[] args){
        int n=181;
        System.out.println(swapBits(n));
    }
}