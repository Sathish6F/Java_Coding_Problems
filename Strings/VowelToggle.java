package Strings;
import java.util.Scanner;
public class VowelToggle {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
        String s=sc.next();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            sb.append(ch);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
                sb.append((char)(ch-' '));   
            else if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                sb.append((char)(ch+' '));
        }
        System.out.println(sb.toString());
    }
}