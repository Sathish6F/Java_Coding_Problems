package ZohoQues;

public class Pattern4 {
	public static void main(String[] args){
        int n=8;
        int stars=(n*2)-1;
        int space=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
            space++;
            stars-=2;
        }
    }
}