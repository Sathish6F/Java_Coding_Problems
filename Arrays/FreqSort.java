package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

//sort the array based on its frequency
//{1,3,2,4,1,3,3,2,2,5,5}
//op:{2,3,1,5,4}
public class FreqSort {
    static void freqSort(int[] nums){
        ArrayList<Integer> al= new ArrayList<>();
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        int[] freq=new int[max+1];
        for(int n:nums){
            freq[n]++;
        }
        int maxfreq=freq[0];
        int minfreq=0;
        for(int i=1;i<freq.length;i++){
            if(freq[i]>=maxfreq){
                maxfreq=freq[i];
                al.add(0,i);
            }
            if(freq[i]<maxfreq && freq[i]>minfreq){
                minfreq=freq[i];
                al.add(i);
            }
            if(freq[i]<minfreq){
                al.add(i);
            }
        }
        System.out.println(Arrays.toString(freq));
        System.out.println(al);
    }
	public static void main(String[] args){
        int[] nums={1,3,2,4,1,3,3,2,2,5,5};
        freqSort(nums);
    }
}