package ZohoQues;
/*
Given two arrays of integers, find which elements in the second array are missing 
from the first array.
Sample Input
10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output
204 205 206

*/
import java.util.*;
public class MissingNumber {
    static List<Integer> missingNumber(List<Integer> arr, List<Integer> brr){
        Map<Integer,Integer> map = new TreeMap<>();
        for(Integer i : brr){
            if(map.containsKey(i)){
                map.put(i,(1+map.get(i)));
            }else{
                map.put(i,1);
            }
        }
        
        for(Integer i : arr){
            if(map.containsKey(i)){
                int c = map.get(i);
                c--;
                map.put(i,c); 
            }else{
                map.put(i,1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry e : map.entrySet()){
            if((Integer)e.getValue() != 0){
                res.add((Integer)e.getKey());
            }
        }
        return res;
    }
	public static void main(String[] args){
        Integer[] a = new Integer[]{203,204, 205, 206, 207, 208, 203, 204, 205, 206};
        Integer[] b = new Integer[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        List<Integer> arr = new ArrayList<>(Arrays.asList(a));
        List<Integer> brr = new ArrayList<>(Arrays.asList(b));
        System.out.println(missingNumber(arr,brr));
    }
}