/*
You are given a string s representing an expression containing various types of brackets: {}, (), and []. 
Your task is to determine whether the brackets in the expression are balanced. 
A balanced expression is one where every opening bracket has a corresponding 
closing bracket in the correct order.
Input: s = "{([])}"
Output: true
*/
package Strings;
import java.util.*;
public class ValidParanthesis {
    public static boolean isValid(String s){
        Stack<Character> stk=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') 
            {
                stk.push(s.charAt(i));
            }
            else
            {
                if(stk.isEmpty()) return false;
                char top=stk.pop();
                if(s.charAt(i)==')' && top !='(') return false;
                if(s.charAt(i)==']' && top !='[') return false;
                if(s.charAt(i)=='}' && top !='{') return false;
            }
        }
        return stk.isEmpty();
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.next();
        System.out.println(isValid(s));
    }
}