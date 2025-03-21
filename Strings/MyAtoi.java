package Strings;

public class MyAtoi {
    static int myAtoi(String s){
        int res=0,sign=1,idx=0;
        while(idx<s.length() && s.charAt(idx)==' '){
            idx++;
        }
        if(idx<s.length() && (s.charAt(idx)=='-' || s.charAt(idx)=='+')){
            if(s.charAt(idx++)=='-'){
                sign=-1;
            }
        }
        while(idx<s.length() && s.charAt(idx)>='0' && s.charAt(idx)<='9'){
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && s.charAt(idx)-'0'>7)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=10*res+(s.charAt(idx++)-'0');
        }
        return res*sign;
    }
	public static void main(String[] args){
        String s="   -123f";
        System.out.println("The int value is:"+myAtoi(s));
    }
}