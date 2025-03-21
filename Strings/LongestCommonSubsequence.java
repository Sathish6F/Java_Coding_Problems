/*
Given two strings s1 and s2, return the length of their longest common subsequence (LCS). 
If there is no common subsequence, return 0.
Input: s1 = "ABCDGH", s2 = "AEDFHR"
Output: 3
Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", 
which has a length of 3.
*/
package Strings;
public class LongestCommonSubsequence {
    public static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
	public static void main(String[] args){
        String s1="ABCDGH";
        String s2="AEDFHR";
        System.out.println(lcs(s1,s2));
    }
}