package ZohoQues;
import java.util.*;
public class Apples_And_Oranges {
    static void countApplesOranges(int s,int t,int a,int b,List<Integer> apples,List<Integer> oranges){
        int acnt = 0,ocnt =0;
        for(int i : apples){
            if(i+a >=s && i+a<=t){
                acnt++;
            }
        }
        for(int i:oranges){
            if(i+b <=t && i+b>=s){
                ocnt++;
            }
        }
        System.out.println(acnt+"\n"+ocnt);
    }
	public static void main(String[] agrs){
        int s = 7;
        int t = 11;
        int a = 4,b= 12;
        List<Integer> apples = new ArrayList<>(Arrays.asList(2,3,-4));
        List<Integer> oranges = new ArrayList<>(Arrays.asList(3,-2,-4));
        countApplesOranges(s,t,a,b,apples,oranges);
    }
}