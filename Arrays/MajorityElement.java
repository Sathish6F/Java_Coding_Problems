/*
You are given an array of integer arr[] where each number represents a vote to a candidate.
Return the candidates that have votes greater than one-third of the total votes, 
If there's not a majority vote, return an empty array. 
Note: The answer should be returned in an increasing format.
Examples:
Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
*/
package Arrays;
import java.util.*;
public class MajorityElement {
    static List<Integer> majorityElement(int[] a){
        int ele1=-1,ele2=-1;
        int cnt1=0,cnt2=0;
        for(int ele:a){
            if(ele1==ele) cnt1++;
            else if(ele2==ele) cnt2++;
            else if(cnt1==0){
                ele1=ele;
                cnt1++;
            }
            else if(cnt2==0){
                ele2=ele;
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> res=new ArrayList<Integer>();
        cnt1=0;
        cnt2=0;
        for(int ele:a){
            if(ele1==ele) cnt1++;
            else if(ele2==ele) cnt2++;
        }
        if(cnt1>(a.length/3)) res.add(ele1);
        if(cnt2>(a.length/3) && ele1!=ele2) res.add(ele2);
        if(res.size()==2 && res.get(0)>res.get(1)){
            int t=res.get(0);
            res.set(0,res.get(1));
            res.set(1,t);
        }
        return res;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array Size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        List<Integer> res=majorityElement(a);
        System.out.println("The majority elements:"+res);

    }
}