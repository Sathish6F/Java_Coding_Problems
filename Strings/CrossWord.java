package Strings;
import java.util.*;
public class CrossWord {
	public static void main(String[] args){
        String s="water";

        char[][] c=new char[s.length()][s.length()];
        for(char[] a:c){
            Arrays.fill(a,' ');
        }
        
        int i=0;
        int mid=c.length/2;
        for(int k=0;k<c[0].length;k++){
            c[k][k]=s.charAt(i);
            c[mid][k]=s.charAt(i);
            c[k][mid]=s.charAt(i++);
        }
        i=0;
        for(int k=s.length()-1;k>=0 && i<c.length;k--){
            c[i++][k]=s.charAt(k);
        }

        for(char[] a:c){
            System.out.println(Arrays.toString(a));
        }
    }
}