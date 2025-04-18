/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.
Input: nums = [1,2,2,4]
Output: [2,3]
*/
package Arrays;
import java.util.Arrays;
public class SetMismatch {
    public static int[] setMismatch(int[] nums){
        int[] hash=new int[nums.length+1];
        int[] res=new int[2];
        for(int n:nums){
            hash[n]++;
        }
        for(int i=1;i<hash.length;i++){
            if(hash[i]>1){
                res[0]=i;
            }
            else if(hash[i]==0){
                res[1]=i;
            }
        }
        return res;
    }
	public static void main(String[] args){
        int[] arr={1,2,2,4};
        System.out.println(Arrays.toString(setMismatch(arr)));
    }
}