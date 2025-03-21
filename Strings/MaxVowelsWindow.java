package Strings;
/*Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
Example 1:
Input: s = "abciiidef", k = 3
Output: 3 Explanation: The substring "iii" contains 3 vowel letters.
*/
public class MaxVowelsWindow {
    public static int maxVowels(String s,int k){
        int max=0;
        int[] vowels=new int[26];
        vowels['a'-'a']=1;
        vowels['e'-'a']=1;
        vowels['i'-'a']=1;
        vowels['o'-'a']=1;
        vowels['u'-'a']=1;
        int curr=0;
        int i =0;
        char[] arr=s.toCharArray();
        int len = arr.length;
        while(i<k){
            if(vowels[arr[i]-'a']==1) curr++;
            i++;
        }
        max=curr;
        while(i<len){
            if(vowels[arr[i-k]-'a']==1) curr--;
            if(vowels[arr[i]-'a']==1) curr++;
            max=Math.max(max,curr);
            i++;
        }
        return max;
    }
	public static void main(String[] args){
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s,k));
    }
}