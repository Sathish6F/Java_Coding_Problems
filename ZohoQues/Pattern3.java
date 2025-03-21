package ZohoQues;

public class Pattern3 {
	public static void main(String[] args){
        int n=7;
        int front=n-1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=front;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
            front-=1;
            
        }
    }
}