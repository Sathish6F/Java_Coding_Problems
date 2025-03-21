package ZohoQues;

public class Pattern5 {
	public static void main(String[] args){
        int n=7;
        int stars=1;
        int spaces=2*(n-1);
        for(int i=1;i<=n*2;i++){
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            if(i<n){
                stars++;
                spaces-=2;
            }
            else if(i>n){
                stars--;
                spaces+=2;
            }
            System.out.println();
        }
    }
}