package Arrays;

public class BitonicArray {

    static int ascendingSearch(int[] a,int key,int range){
        int l = 0,h = range-1;
        int mid =0;
        while(l <= h){
            mid = (l+h)/2;
            if(a[mid] == key){
                return mid;
            }
            else if(a[mid] < key){
                l = mid +1;
            }else{
                h = mid -1;
            }
        }
        return -1;
    }
     static int descendingSearch(int[] a,int key,int range){
        int l = range+1,h = a.length-1;
        int mid =0;
        while(l <= h){
            mid = (l+h)/2;
            if(a[mid] == key){
                return mid;
            }
            else if(a[mid] < key){
                h = mid -1;
            }else{
                l = mid +1;
            }
        }
        return -1;
    }
    static int findBitonicIndex(int[] a){
        int l = 0;
        int r = a.length-1;
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(a[mid] > a[mid-1] && a[mid] > a[mid+1]){
                return mid;
            }
            else if(a[mid] > a[mid-1] && a[mid] < a[mid+1]){
                l = mid;
            }else{
                r = mid;
            }
        }
        return -1;
    }
    static int bitonicSearch(int[] a,int key,int bIndex){
        if(a[bIndex] == key){
            return bIndex;
        }
        if(a[bIndex]<key){
            return -1;
        }
        int res1 = ascendingSearch(a, key, bIndex);
        if(res1 != -1){
            return res1;
        }
        int res2 = descendingSearch(a, key, bIndex);
        if(res2 != -1){
            return res2;
        }
        return -1;
    }
	public static void main(String[] args){
        int[] a = {1,4,5,12,15,20,3,2,0};
        int key = 2;
        int bIndex = findBitonicIndex(a);
        System.out.println(bitonicSearch(a, key, bIndex));
    }
}