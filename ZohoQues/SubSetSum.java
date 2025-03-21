package ZohoQues;

public class SubSetSum {
    public static int countSubSets(int[] ar,int sum,int i){
        if(sum == 0){
            return 1;
        }
        if(sum < 0){
            return 0;
        }
        if(i == ar.length){
            return 0;
        }
        return countSubSets(ar, sum-ar[i], i+1)+countSubSets(ar, sum, i+1);
    }
	public static void main(String[] args){
        int[] ar = {10,20,15,5,10};
        System.out.println(countSubSets(ar,25,0));
    }
}