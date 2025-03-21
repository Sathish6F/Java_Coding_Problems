package ZohoQues;
/*
You are given an integer array arr. Sort the integers in the array in ascending order 
by the number of 1's in their binary representation and in case of two or more integers
 have the same number of 1's you have to sort them in ascending order.
Return the array after sorting it.
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
*/
import java.util.*;
public class SortByBits {

    public static int countBits(int n){
        int c = 0;
        while(n != 0){
            c++;
            n = n & (n-1);
        }
        return c;
    }
    
    public static int[] sortByBits(int[] arr){
        Arrays.sort(arr);
        TreeMap<Integer,LinkedList<Integer>> map = new TreeMap<>();
        for(int n : arr){
            int bitCounts = countBits(n);
            if(map.containsKey(bitCounts)){
                map.get(bitCounts).add(n);
            }else{
                LinkedList<Integer> list = new LinkedList<>();
                list.add(n);
                map.put(bitCounts,list);
            }
        }
        int[] res = new int[arr.length];
        int idx = 0;
        for(LinkedList<Integer> l : map.values()){
            for(Integer i : l){
                res[idx++] = i;
            }
        }
        return res;
    }
	public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }
}