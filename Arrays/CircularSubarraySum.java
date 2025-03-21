/*
Given a circular array arr[] of size n, find the maximum possible sum of a non-empty subarray.
    Input: arr[] = {8, -8, 9, -9, 10, -11, 12}
    Output: 22
    Explanation: Circular Subarray {12, 8, -8, 9, -9, 10} has the maximum sum, which is 22.
*/
package Arrays;
public class CircularSubarraySum {
    public static int circularSubarraySum(int[] a){
        int totalSum=0;
        int currMin=0,currMax=0;
        int maxSum=a[0],minSum=a[0];
        for(int i=0;i<a.length;i++){
            currMax=Math.max(a[i],a[i]+currMax);
            maxSum=Math.max(maxSum,currMax);

            currMin=Math.min(a[i],a[i]+currMin);
            minSum=Math.min(minSum,currMin);

            totalSum+=a[i];
        }
        int normalSum=maxSum;
        int circularSum=totalSum-minSum;
        if(totalSum==minSum) return normalSum;
        return Math.max(circularSum,normalSum);

    }
	public static void main(String[] args){
        int[] a={8,-8,9,-9,10,-11,12};
        System.out.println("The maximum circular sub array sum is:");
        System.out.println(circularSubarraySum(a));
    }
}