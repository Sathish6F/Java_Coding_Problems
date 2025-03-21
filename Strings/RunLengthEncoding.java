/*
Given a string s, Your task is to complete the function encode that returns the 
run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
*/
package Strings;
public class RunLengthEncoding {
    public static String encode(String s){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int cnt=1;
            char c=s.charAt(i);
            while(i<s.length()-1 && c==s.charAt(i+1)){
                cnt++;
                i++;
            }
            sb.append(c);
            sb.append(cnt);
        }
        return sb.toString();
    }
	public static void main(String[] args){
        String s="wwwwaaadexxxxxx";
        System.out.println("The encoded string is:"+encode(s));
    }
}