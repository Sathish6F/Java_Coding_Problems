package ZohoQues;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

*/
public class EditDistance {
    static int minDistance(String word1,String word2){

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i = 0; i < word1.length()+1; i++){
            dp[i][word2.length()] = word1.length() - i;
        }

        for(int i = 0; i < word2.length()+1; i++){
            dp[word1.length()][i] = word2.length() - i;
        }

        for(int i = word1.length()-1; i >= 0; i--){
            for(int j = word2.length()-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
	public static void main(String[] args){
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }
}