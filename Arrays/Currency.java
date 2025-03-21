/*
Given an amount, find the minimum number of notes of different denominations that
sum up to the given amount. Starting from the highest denomination note, try to accommodate 
as many notes as possible for a given amount. We may assume that we have infinite supply of 
notes of values {2000, 500, 200, 100, 50, 20, 10, 5, 1} 
Examples:  
    Input : 800
    Output : Currency  Count 
             500 : 1
             200 : 1
             100 : 1
*/
package Arrays;
public class Currency {
    public static void currencySum(int[] values,int amt){
        int[] counter=new int[9];
        for(int i=0;i<values.length;i++){
            if(amt>=values[i]){
                counter[i]=amt/values[i];
                amt=amt%values[i];
            }
        }
        for(int i=0;i<9;i++){
            if(counter[i]!=0){
                System.out.println(values[i]+":"+counter[i]);
            }
        }
    }
	public static void main(String[] args){
        int[] values={2000, 500, 200, 100, 50, 20, 10, 5, 1};
        int amount=2053;
        currencySum(values,amount);
    }
}