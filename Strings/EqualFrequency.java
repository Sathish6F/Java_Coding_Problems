/*
You are given a 0-indexed string word, consisting of lowercase English letters. 
You need to select one index and remove the letter at that index from word so that the 
frequency of every letter present in word is equal. Return true if it is possible to 
remove one letter so that the frequency of all letters in word are equal, and false otherwise.
Input: word = "abcc"
Output: true
Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
*/
package Strings;
public class EqualFrequency {
    public static boolean equalFrequency(String word){
        int[] hash = new int[26];
        for(int i=0;i<word.length();i++){
            hash[word.charAt(i)-'a']++;
        }
        for(int i=0;i<word.length();i++){
            hash[word.charAt(i)-'a']--;
            if(validRemove(hash)){
                return true;
            }
            hash[word.charAt(i)-'a']++;
        }
        return false;
    }
    public static boolean validRemove(int[] hash){
        int max=0;
        for(int i:hash){
            if(i>max){
                max=i;
            }
        }
        int[] temp=new int[max+1];
        for(int i:hash){
            temp[i]++;
        }
        int cnt=0;
        for(int i=1;i<temp.length;i++){
            if(temp[i]>0){
                cnt++;
            }
        }
        return (cnt==1);
    }
	public static void main(String[] args){
        String word="abcc";
        System.out.println(equalFrequency(word));
    }
}