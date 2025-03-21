/*
Given two arrays, a[] and b[], find the length of the longest common increasing subsequence(LCIS). 
Example:
Input: a[] = [3, 4, 9, 1], b[] = [5, 3, 8, 9, 10, 2, 1]
Output: 2
Explanation: The longest increasing subsequence that is common is {3, 9} and its length is 2.
*/
package Arrays;
public class LCIS {
    public static int lcis(int[] a,int[] b){
        int m=a.length;
        int n=b.length;
        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            int currLength=0;
            for(int j=0;j<n;j++){
                if(a[i]==b[j]){
                    dp[j]=Math.max(currLength+1,dp[j]);
                }
                else if(a[i]>b[j]){
                    currLength=Math.max(dp[j],currLength);
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    public static void main(String[] args){
        int[] a={3,4,9,1};
        int[] b={5, 3, 8, 9, 10, 2, 1};
        System.out.println(lcis(a,b));
    }
	
}