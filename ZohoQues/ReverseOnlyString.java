package ZohoQues;
/*
Given a string s, reverse the string according to the following rules:
    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.
Example 1:
Input: s = "ab-cd"
Output: "dc-ba"
*/
public class ReverseOnlyString {
    static String reverse(String s){
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toCharArray();

        while(l <= r){
            if(Character.isAlphabetic(arr[l]) && Character.isAlphabetic(arr[r])){
                char c = arr[l];
                arr[l] = arr[r];
                arr[r] = c;
                l++;
                r--;
            }
            else if(! Character.isAlphabetic(arr[l])){
                l++;
            }
            else if(! Character.isAlphabetic(arr[r])){
                r--;
            }
        }
        return new String(arr);
    }
	public static void main(String[] args){
        String s = "ab-cd";
        System.out.println(reverse(s));
    }
}