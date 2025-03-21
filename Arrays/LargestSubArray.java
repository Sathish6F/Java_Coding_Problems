/*
Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
Examples:
Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
*/
package Arrays;
import java.util.HashMap;
public class LargestSubArray {
    public static int largestSubArray(int[] arr){
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=-1;
            }
        }
        int sum=0;
        int maxlength=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                maxlength=i+1;
                continue;
            }
            if(map.containsKey(sum)){
                maxlength=Math.max(maxlength,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxlength;
    }
	public static void main(String[] args){
        int[] arr={1,0,1,0};
        System.out.println(largestSubArray(arr));
    }
}