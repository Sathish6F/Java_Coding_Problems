package ZohoQues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
The next greater element of some element x in an array is the first greater element 
that is to the right of x in the same array.You are given two distinct 0-indexed 
integer arrays nums1 and nums2, where nums1 is a subset of nums2.
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
*/
public class NextGreatest {
    public static int[] nextGreatest(int[] n1, int[] n2){
        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = n2.length-1 ; i >= 0; i--){
            int n = n2[i];
            while(!stk.isEmpty() && n >= stk.peek()){
                stk.pop();
            }
            if(stk.isEmpty()){
                map.put(n,-1);
            }else{
                map.put(n,stk.peek());
            }
            stk.push(n);
        }
        for(int i = 0; i < n1.length; i++){
            n1[i] = map.containsKey(n1[i]) ? map.get(n1[i]) : -1;
        }
        return n1;
    }
	public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreatest(nums1,nums2)));
    }
}