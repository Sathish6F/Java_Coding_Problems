/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
Input: s = "III"
Output: 3
*/
package Strings;
import java.util.Scanner;
public class RomanToInt {
    public static int romanToInt(String s){
        int[] roman=new int[128];
        roman['I']=1;
        roman['V']=5;
        roman['X']=10;
        roman['L']=50;
        roman['C']=100;
        roman['D']=500;
        roman['M']=1000;
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            if(roman[s.charAt(i)]<roman[s.charAt(i+1)]){
                ans-=roman[s.charAt(i)];
            }
            else{
                ans+=roman[s.charAt(i)];
            }
        }
        ans+=roman[s.charAt(s.length()-1)];
        return ans;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Roman number:");
        String s=sc.next();
        System.out.println("The integer value:"+romanToInt(s));
    }
}