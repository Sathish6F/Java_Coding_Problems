/*
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.
Examples:
Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
*/
package Arrays;
import java.util.*;
public class SubArrayDistinctNumbers {
    public static ArrayList<Integer> countDistinct(int[] arr,int k){
        ArrayList<Integer> list = new ArrayList<>();
        int start=0;
        while(start+k<=arr.length){
            int n=distinctCount(arr,start,k);
            list.add(n);
            start++;
        }
        return list;
    }
    public static int distinctCount(int[] arr,int start,int k){
        int cnt=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=start;i<start+k;i++){
            if(map.containsKey(arr[i])){
                if(map.get(arr[i])>1){
                    cnt--;
                }
            }
            else{
                map.put(arr[i],1);
                cnt++;
            }
        }
        return cnt;
    }
	public static void main(String[] args){
        int[] arr={1,2,1,3,4,2,3};
        int k=4;
        System.out.println(countDistinct(arr,k));
    }
}