package Arrays;
/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]*/
public class FirstLastIndex {
    public static int[] findRange(int[] nums,int target){
        int[] res = {-1,-1};
        int low = 0,high = nums.length-1,mid =0;
        while(low <= high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                res[0] = mid;
                high = mid -1;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        low = 0;
        high = nums.length-1;
        mid =0;
        while(low <= high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                res[1] = mid;
                low = mid +1;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return res;
    }
	public static void main(String[] args){
        int[] nums ={5,7,7,8,8,10};
        int target = 6;
        int[] res = findRange(nums,target);
        System.out.println("["+res[0]+","+res[1]+"]");
    }
}