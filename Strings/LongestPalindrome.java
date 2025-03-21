/*
Given a string s, find the longest palindromic subsequence.
Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
*/
package Strings;
public class LongestPalindrome {
    public static int lps(String s){
        int n=s.length();
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
	public static void main(String[] args){
        String s="bbabcbcab";
        System.out.println(lps(s));
    }
}