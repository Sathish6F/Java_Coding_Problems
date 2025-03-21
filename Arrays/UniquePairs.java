package Arrays;
import java.util.*;
public class UniquePairs {
    static List<ArrayList<Integer>> uniquePairs(int[] a,int k){
        List<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.length;i++){
            ArrayList<Integer> al=new ArrayList<Integer>();
            boolean flag=false;
            for(int j=i+1;j<a.length;j++){
                if(a[i]*a[j]==k){
                    al.add(a[i]);
                    al.add(a[j]);
                    i=j;
                    flag=true;
                    break;
                }
            }
            if(flag)
                l.add(al);
        }
        return l;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Enter K value:");
        int k=sc.nextInt();
        List<ArrayList<Integer>> l= uniquePairs(a,k);
        System.out.println(l);
    }
}