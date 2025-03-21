/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. All houses at this place 
are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have a security system connected, and it will automatically contact
the police if two adjacent houses were broken into on the same night.
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
*/
package Arrays;
public class HouseRobber2 {
    public static int robHouse2(int[] nums){
        int n=nums.length;
        if(n==1) return nums[0];
        int r1=getMax(nums,0,n-2);
        int r2=getMax(nums,1,n-1);
        return Math.max(r1,r2);
    }
    public static int getMax(int[] nums,int start,int end){
        int max=0,prev=0;
        for(int i=start;i<=end;i++){
            int temp=Math.max(max,prev+nums[i]);
            prev=max;
            max=temp;
        }
        return max;
    }
	public static void main(String[] args){
        int[] nums={1,2,1};
        System.out.println(robHouse2(nums));
    }
}