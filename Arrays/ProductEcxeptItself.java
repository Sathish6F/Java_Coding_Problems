/*
Given an array, arr[], construct a product array, pro[] where each element pro[i] is the product of all elements in arr except arr[i]. 
Return this resultant array, pro[].
Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
*/
package Arrays;
import java.util.Arrays;
public class ProductEcxeptItself {
    static void productExceptItself(int[] a){
        int c=0;
        long prod=1l;
        long[] res=new long[a.length];
        for(int num:a){
            if(num==0) c++;
            else prod*=num;
        }
        for(int i=0;i<a.length;i++){
            if(c>1) res[i]=0;
            else if(c==1){
                if(a[i]==0) res[i]=prod;
                else res[i]=0;
            }
            else res[i]=prod/a[i];
        }
        System.out.println(Arrays.toString(res));
    }
	public static void main(String[] args){
        int[] a={1,2,3,4,5};
        productExceptItself(a);
    }
}