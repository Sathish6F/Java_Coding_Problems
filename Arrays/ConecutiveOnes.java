package Arrays;
/*Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.*/
import java.util.*;
public class ConecutiveOnes {
    public static int maxConsecutiveOne(int[] nums,int k){
        int max_w=0;
        int num_zeros=0;
        int l=0;
        int w=0;
        for(int r = 0;r<nums.length;r++){
            if(nums[r]==0){
                num_zeros++;
            }
            while(num_zeros>k){
                if(nums[l]==0){
                    num_zeros--;
                }
                l++;
            }
            w=r-l+1;
            max_w = Math.max(w,max_w);
        }
        return max_w;
    }
    public static void usingStack(int[] nums,int k){
        Stack<Integer> stk =new Stack<>();
        int max=0;
        int cur=0;
        int num_zeros=0;
        int right=0;
        for(int i =right;i<nums.length;i++){
            if(nums[i]==0){
                num_zeros++;
            }
            if(num_zeros==k){
                stk.push(i);
                System.out.println(stk);
            }
            if(num_zeros>k){
                cur=stk.pop();
                max=Math.max(cur,max);
                num_zeros=0;
                i=right++;
            }
            
        }
        System.out.println(max);
    }
	public static void main(String[] args){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k =2;
        System.out.println(maxConsecutiveOne(nums,k));
        //usingStack(nums, k);
    }
}