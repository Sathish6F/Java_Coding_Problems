package Strings;
import java.util.Scanner;
public class SubString {
    public  String subString(String s){
        int left=0;
        int cnt,maxcnt=0;
        int start=0,end=0;
        while(left<s.length()){
            for(int i=left;i<s.length();i++){
                cnt=0;
                char ch=s.charAt(i);
                l1:for(int j=i+1;j<s.length();j++){
                    for(int k=j-1;k>=left;k--){
                        if(s.charAt(k)==s.charAt(j)){
                            break l1;
                        }
                    }
                    if(ch!=s.charAt(j)){
                        cnt++;
                        ch=s.charAt(j);
                    }
                    if(cnt>maxcnt){
                        maxcnt=cnt;
                        start=i;
                        end=j;
                    }
                }
            }
            left++;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=start;i<=end;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.next();
        System.out.println(new SubString().subString(s));
    }
}