package ZohoQues;
//Rope cutting problem
//input : n-15 rope length
// a=5,b=8,c=7 the possible cuts
//output = 3
public class RopeCutting {
    public static int ropeCut(int n,int a,int b,int c){
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return -1;
        }
        int temp1 = ropeCut(n-a, a, b, c);
        int temp2 = ropeCut(n-b, a, b, c);
        int temp3 = ropeCut(n-c, a, b, c);
        int peices = Math.max(temp1,Math.max(temp2, temp3));

        if(peices < 0){
            return -1;
        }
        return peices+1;
    }
	public static void main(String[] args){
        int res = ropeCut(15,5,7,8);
        System.out.println(res);
    }
}