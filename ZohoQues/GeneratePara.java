package ZohoQues;

import java.util.ArrayList;

/*
Given n pairs of parentheses, write a function to generate all combinations of 
well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
import java.util.List;
public class GeneratePara {
    public static List<String> generateParanthesis(int n){
        List<String> res = new ArrayList<>();
        char[] ar = new char[n*2];
        int i = 0;
        balancedPara(ar,i,n,0,0,res);
        return res;
    }
    public static void balancedPara(char[] ar,int i,int n,int open,int close,List<String> res){
        if(i == ar.length){
            res.add(new String(ar));
            return;
        }
        if(open < n){
            ar[i] = '(';
            balancedPara(ar, i+1, n, open+1, close, res);
        }
        if(close < open){
            ar[i] = ')';
            balancedPara(ar, i+1, n, open, close+1, res);
        }
    }
	public static void main(String[] args){
        int n = 4;
        System.out.println(generateParanthesis(n));
    }
}