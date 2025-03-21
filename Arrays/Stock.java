/*
The cost of stock on each day is given in an array price[]. Each day you may decide to either 
buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. 
Find the maximum profit that you can get.
Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on 
any given day.
Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. 
Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
*/
package Arrays;
import java.util.Scanner;
public class Stock {
    public static int maxProfit(int[] prices){
        int res=0;
        int i=0;
        int lMin=prices[0];
        int lMax=prices[0];
        while(i<prices.length-1){
            while(i<prices.length-1 &&  prices[i]>=prices[i+1])
                i++;
            lMin=prices[i];
            while(i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            lMax=prices[i];
            res+=(lMax-lMin);
        }
        return res;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("The max profit is:"+maxProfit(a));
    }
}