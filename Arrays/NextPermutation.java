/*
Given an array of integers arr[] representing a permutation, implement the next permutation 
that rearranges the numbers into the lexicographically next greater permutation. If no such permutation 
exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 
Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
Examples:
Input: arr = [2, 4, 1, 7, 5, 0]
Output: [2, 4, 5, 0, 1, 7]
Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.
*/
package Arrays;
import java.util.Scanner;
public class NextPermutation {
    static void nextPermutation(int[] a){
        int n = a.length;
        int pivot = -1;
        for(int i = n-2;i >= 0;i--){
            if(a[i] < a[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse(a,0,n-1);
            return;
        }
        for(int i = n-1;i > pivot;i--){
            if(a[i] > a[pivot]){
                swap(a,i,pivot);
                break;
            }
        }
        reverse(a,pivot+1,n-1);
    }
    static void reverse(int[] a,int start,int end){
        while(start < end){
            swap(a,start++,end--);
        }
    }
    static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	public static void main(String[] args){
       
        int[] a = {2, 4, 1, 7, 5, 0};
        nextPermutation(a);
        System.out.println("The next permutation is");
        for(int num : a){
            System.out.print(num);
        }
    }
}