/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/
package Strings;
import java.util.*;
public class LongestSubString {
    public static int longestSubString(String s){
        int left = 0;
        int start = 0;
        int maxlength = 0;
        HashSet<Character> charSet = new HashSet<Character>();
        for(int i = 0;i < s.length();i++){
            while(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(i));
            if(maxlength < i-left+1){
                maxlength = i-left+1;
                start = i-left+1;
            }
        }
        System.out.println(s.substring(start,start+maxlength));
        return maxlength;
    }
	public static void main(String[] args){
        String s="abcabcbb";
        System.out.println(s);
        System.out.println(longestSubString(s));
    }
}