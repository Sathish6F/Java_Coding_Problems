/*
Given a string s, return the longest palindromic substring in s.
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Input: s = "cbbd"
Output: "bb"
*/
package Strings;
import java.util.Scanner;
public class PalindromicSubString {
    public static String palindromicSubString(String s){
        int n=s.length();
        if(n==0) return "";
        int start=0,maxlen=1,currlen;
        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++){
                int low=i;
                int high=i+j;
                while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                    currlen=high-low+1;
                    if(currlen>maxlen){
                        start=low;
                        maxlen=currlen;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start,start+maxlen);
    }
    
	public static void main(String[] args){
        
        System.out.println("The longest palindromic sub string is:"+palindromicSubString("racecarmalayalam"));
    }
}