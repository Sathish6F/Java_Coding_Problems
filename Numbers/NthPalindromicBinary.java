package Numbers;

public class NthPalindromicBinary {
    static int reverse(int n, int len){
        int f = len - 1,l = 0;
        int rev = 0;
        while(f > l){
            if(((1<<f) & n )!= 0){
                rev = rev | (1<<l);
            }
            if(((1<<l) & n) != 0){
                rev = rev | (1<<f);
            }
            f--;
            l++;
        }
        return rev;
    }
    public static int nthPalindrome(int n){
        int len = 0,count = 0;
        while(count < n){
            len++;
            count += (int)Math.pow(2,(len-1)/2);
        }
        count = count - (int)Math.pow(2,(len-1)/2);
        int ele = n - count - 1;
        int ans =  (ele << (len/2)) | (1 << (len -1));
        ans = ans | reverse(ans,len);
        return ans;
    }
	public static void main(String[] args){
        int n = 20;
        System.out.println(Integer.toBinaryString(nthPalindrome(n)));
    }
}