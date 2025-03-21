package Arrays;
import java.util.Arrays;
public class BinarySort {
    
    public static int getOnesCount(int n){
        int cnt = 0;
        while(n!=0){
            cnt++;
            n = (n & (n-1));
        }
        return cnt;
    }
    public static void binarySort(int[] a){
        for(int i = 0;i<a.length-1;i++){
            if(getOnesCount(a[i]) > getOnesCount(a[i+1])){
                int t = a[i];
                a[i] =a[i+1];
                a[i+1] = t;
                i = 0;
            }
        }
    }
	public static void main(String[] args){
        int[] a = {5,4,3,2,1};
        binarySort(a);
        System.out.println(Arrays.toString(a));
    }
}