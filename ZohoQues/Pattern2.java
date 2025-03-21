package ZohoQues;

public class Pattern2 {
	public static void main(String[] args){
        int n=11;
        int outer=n/2+1;
        int inner=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=outer;j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=1;j<inner;j++){
                System.out.print(" ");
            }
            if(i!=1 && i!=n){
             System.out.print("*");
            }
            System.out.println();

            if(i< n/2+1){
                outer-=1;
                inner+=2;
            }
            if(i>=n/2+1){
                outer+=1;
                inner-=2;
            }
        }
    }
}