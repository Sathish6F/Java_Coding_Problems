/*
You are playing the Bulls and Cows game with your friend.
You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
*/
package Strings;
public class BullsAndCows {
    public static String getHint(String secret,String guess){
        int bullcnt = 0;
        int cowcnt = 0;
        int[] nums = new int[10];
        for(int i = 0;i < secret.length();i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if(s == g){
                bullcnt++;
            }
            else{
                if(nums[s] < 0) cowcnt++;
                if(nums[g] > 0) cowcnt++;
                nums[s]++;
                nums[g]--;
            }
        }
        return bullcnt+"A"+cowcnt+"B";
    }
	public static void main(String[] args){
        String secret = "1807";
        String guess = "7810";
        System.out.println(getHint(secret,guess));
    }
}