package Matrix;
import java.util.Scanner;
public class HourGlass {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N value:");
        int n=sc.nextInt();
        char[][] arr=new char[n][n];
        
        for(int i=0;i<n;i++){
            int j=0;
            while(i<n/2 && j<n){
                if(j>=i && j<n-i){
                    arr[i][j++]='*';
                }
                else{
                    arr[i][j++]=' ';
                }
            }
            j=0;
            while(i>=n/2 && j<n){
                if(j>=(n-i)-1 && j<=i){
                    arr[i][j++]='*';
                }
                else{
                    arr[i][j++]=' ';
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}