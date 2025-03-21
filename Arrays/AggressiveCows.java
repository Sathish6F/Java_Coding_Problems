/*
You are given an array with unique elements of stalls[], which denote the position 
of a stall. You are also given an integer k which denotes the number of aggressive cows. 
Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
*/
package Arrays;
import java.util.Arrays;
public class AggressiveCows {
    public static boolean check(int[] arr,int k,int dis){
        int cnt = 1;
        int prev = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(arr[i] - prev >= dis){
                cnt++;
                prev = arr[i];
            }
        }
        return (cnt >= k);
    }
    public static int findDistance(int[] arr,int k){
        int res = 0;
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length-1] - arr[0];
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(arr,k,mid)){
                res = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
    }
	public static void main(String[] args){
        int[] stalls={1, 2, 4, 8, 9};
        int k=3;
        System.out.println("The minimum distance is:"+findDistance(stalls,k));
    }
}