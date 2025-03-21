package Numbers;
//Kernihan's Algorithm
public class CountSetBits {
    static int countSetBits(int n){
        int cnt = 0;
        while(n != 0){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }
	public static void main(String[] args){
        int n=45;
        System.out.println(countSetBits(n));
    }
}