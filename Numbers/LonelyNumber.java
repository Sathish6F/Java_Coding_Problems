/*
Given an array with 2n+1 integers, n elements appear twice in arbitrary places 
in the array and a single integer appears only once somewhere inside. 
Find the lonely integer with O(n) operations and O(1) extra memory.
Input : { 1, 1, 2, 2, 3, 3, 4, 4, 5}
Output : 5
XOR properties
 a ^ a =0
 a ^ 0 =a
*/
package Numbers;
public class LonelyNumber {
    static int lonelyNumber(int[] nums){
        int res = 0;
        for(int i : nums){
            res = res ^ i;
        }
        return res;
    }
	public static void main(String[] args){
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        System.out.println(lonelyNumber(nums));
    }
}