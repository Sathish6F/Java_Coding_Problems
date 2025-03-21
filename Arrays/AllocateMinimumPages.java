/*
You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:
    Each student receives atleast one book.
    Each student is assigned a contiguous sequence of books.
    No book is assigned to more than one student.
Note: 
Return -1 if a valid assignment is not possible, and allotment should be in contiguous order 
Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
*/
package Arrays;
public class AllocateMinimumPages {

    public static int max(int[] arr){
        int max = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int sum(int[] arr){
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        return sum;
    }

    public static boolean check(int[] arr,int pagelimit,int k){
        int cnt = 1;
        int pagesum = 0;
        for(int i = 0;i < arr.length;i++){
            if(pagesum + arr[i] > pagelimit){
                pagesum = arr[i];
                cnt++;
            }
            else{
                pagesum += arr[i];
            }
        }
        return (cnt <= k);
    }

    public static int findPages(int[] arr,int k){
        int res = -1;
        int low = max(arr);
        int high = sum(arr);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(arr,mid,k)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    
	public static void main(String[] args){
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println("The minimum pages allocated is:"+findPages(arr,k));
    }
}