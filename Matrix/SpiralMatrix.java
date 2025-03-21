package Matrix;
//Print the matrix in the spiral pattern
//1 2 3 4 5
//16 17 18 19 6
//15 24 25 20 7
//14 23 22 21 8
//13 12 11 10 9
public class SpiralMatrix {
    public static void main(String[] args){
	int row=5;
    int col=5;
    int[][] a=new int[row][col];
    int row_start=0;
    int col_start=0;
    int row_end=row-1;
    int col_end=col-1;
    int n=1;
    while(row_start<=row_end){
        for(int i=col_start;i<=col_end;i++)
            a[row_start][i]=n++;
        row_start++;
        for(int i=row_start;i<=row_end;i++)
            a[i][col_end]=n++;
        col_end--;
        if(col_start<col_end){
        for(int i=col_end;i>=col_start;i--)
            a[row_end][i]=n++;
        row_end--;
        }
        if(row_start<row_end){
        for(int i=row_end;i>=row_start;i--)
            a[i][col_start]=n++;
        col_start++;
        }
    }
    System.out.println("Spiral Matrix");
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            System.out.print(a[i][j]+" ");
        }
        System.out.println();
    }
    }
}