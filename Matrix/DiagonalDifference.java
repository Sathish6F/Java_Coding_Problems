/*
Given a square matrix, calculate the absolute difference between the sums of its diagonals.
For example, the square matrix
is shown below: 
3
11 2 4
4 5 6
10 8 -12 
15
*/
package Matrix;
import java.util.*;
public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr){
        int d1_sum=0;
        int d2_sum=0;
        int len=arr.get(0).size()-1;
        int i=0;
        while(i<arr.size()){
            d1_sum+=arr.get(i).get(len-i);
            d2_sum+=arr.get(i).get(i);
            i++;
        }
        return Math.abs(d1_sum-d2_sum);
    }
	public static void main(String[] args){
        Integer[] r1={11,2,4};
        Integer[] r2={4,5,6};
        Integer[] r3={10,8,-12};
        List<Integer> l1=Arrays.asList(r1);
        List<Integer> l2=Arrays.asList(r2);
        List<Integer> l3=Arrays.asList(r3);
        List<List<Integer>> l=new ArrayList<List<Integer>>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        System.out.println(diagonalDifference(l));
    }
}