/*
input:"ZoHhO"    "OOOoooPpSs"
output:"Z"       "-1"
*/
package Strings;
import java.util.*;
public class RemoveKPairs {
    public static String removePairs(String s){
        
    }
    public static String removeKPairs(String s){
        if(s.length()==0) return "-1";

        StringBuffer sb= new StringBuffer(s);
        boolean flag=false;
        for(int i=0;i<sb.length()-1;i++){
            if((sb.charAt(i)>='a' && sb.charAt(i)<='z') && (sb.charAt(i+1)==sb.charAt(i)-' ')){
                sb.delete(i,i+2);
                flag=true;
                i=0;
                continue;
            }
            else if((sb.charAt(i)>='A' && sb.charAt(i)<='Z') && (sb.charAt(i+1)==sb.charAt(i)+' ')){
                sb.delete(i,i+2);
                i=0;
                flag=true;
            }
        }

        if(!flag) return s;
        return removeKPairs(sb.toString());
    }
	public static void main(String[] args){
        String s="pPoGgoOOGGgg";
        System.out.println(s);
        System.out.println(removeKPairs(s));
    }
}