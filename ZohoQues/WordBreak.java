package ZohoQues;
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented 
into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
*/
public class WordBreak {
    static boolean wordBreak(String s, String[] wordDict){
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i <= s.length() ; i++){
            for(String word : wordDict){
                int start = i - word.length();
                if(start >= 0 && dp[start] && s.substring(start,i).equals(word)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
	public static void main(String[] args){
        String s = "leetcode";
        String[] wordDict = {"leet","code"};
        System.out.println(wordBreak(s,wordDict));
    }
}