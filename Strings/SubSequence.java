package Strings;

import java.util.ArrayList;

public class SubSequence {
    static ArrayList<String> al = new ArrayList<>();
    public static void gss(String s,String ans){
        if(s.length() == 0){
            al.add(ans);
            return;
        }
        gss(s.substring(1),ans+s.charAt(0));
        gss(s.substring(1),ans);
    }
	public static void main(String[] args) {
        String s = "abcd";
        gss(s,"");
        System.out.println(al);
    }
}