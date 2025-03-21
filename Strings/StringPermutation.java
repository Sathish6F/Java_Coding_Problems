package Strings;

public class StringPermutation {
    public static void permutation(char[] ar,int fi){
        if(fi == ar.length-1){
            System.out.println(ar);
            return;
        }
        for(int i = fi; i < ar.length; i++){
            swap(ar,i,fi);
            permutation(ar, fi+1);
            swap(ar,i,fi);
        }
    }
    public static void swap(char[] ar,int i,int j){
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
	public static void main(String[] args){
        String s = "abcd";
        permutation(s.toCharArray(), 0);
    }
}