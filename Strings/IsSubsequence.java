/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
Input: s = "abc", t = "ahbgdc"
Output: true

*/
package Strings;
import java.util.*;
public class IsSubsequence {
    public static boolean isSequence(String s,String t){
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()){
            stk.push(c);
        }
        for(int i= t.length()-1;i>=0 && !stk.isEmpty();i--){
            if(stk.peek()==t.charAt(i)){
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
    public static boolean isSubsequence(String s,String t){
        if(s.length()==0) return true;
        int j=0;
        for(int i=0;i<t.length() && j<s.length();i++){
            if(s.charAt(j)==t.charAt(i) && j<=i){
                j++;
            }
            else if(j>i){
                return false;
            }
        }
        return (s.length()==j);
    }
	public static void main(String[] args){
        String s="abc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println(isSequence(s, t));
    }
}