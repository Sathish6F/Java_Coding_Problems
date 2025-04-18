// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
      int[][] sheet={{1,22,33,44},
                    {2,45,67,89},
                    {3,21,54,78},
                    {4,67,98,11}
      };
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter The Column to Select:");
      char col = sc.next().charAt(0);
      System.out.println("Enter The Conditon:");
      String con = sc.next();
      display(sheet,col,con);
    }
    
    public static void display(int[][] sheet,char col,String con){
        int colToCheck = con.charAt(0)-'A'+1;
        char operation = con.charAt(1);
        int range = Integer.parseInt(con.substring(2));
        if(col=='*'){
            for(int i=0;i<sheet.length;i++){
                if((operation=='>' && sheet[i][colToCheck]>range) || (operation=='<' && sheet[i][colToCheck]<range) ||(operation=='=' && sheet[i][colToCheck]==range)){
                for(int j=0;j<sheet[0].length;j++){
                    System.out.print(sheet[i][j]+" ");
                }
                System.out.println();
                }
            }
        }else{
            for(int i=0;i<sheet.length;i++){
                if((operation=='>' && sheet[i][colToCheck]>range) || (operation=='<' && sheet[i][colToCheck]<range) ||(operation=='=' && sheet[i][colToCheck]==range)){
                    System.out.println(sheet[i][col-'A'+1]);
                }
            }
        }
    }
}
