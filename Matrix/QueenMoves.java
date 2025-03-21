/*
Consider a N X N chessboard with a Queen and K obstacles. The Queen cannot pass through
obstacles. Given the position (x, y) of Queen, the task is to find the number of 
cells the queen can move.
Examples: 
Input : N = 8, x = 4, y = 4, 
        K = 0
Output : 27
*/
package Matrix;
import java.util.Arrays;
public class QueenMoves {
    public static int queenMoves(int n,int x,int y,int k,int[] xpos,int[] ypos){
        int[][] board=new int[n][n];
        board[x][y]=8;
        for(int i=0;i<xpos.length;i++){
            board[xpos[i]][ypos[i]]=1;
        }
        int count=0;
        //up side counts
        for(int i=x-1;i>=0;i--){
            if(board[i][y]==0){
                board[i][y]=3;
                count++;
            }else if(board[i][y]==1){
                break;
            }
        }
        //down side counts
        for(int i=x+1;i<board.length;i++){
            if(board[i][y]!=1){
                board[i][y]=3;
                count++;
            }else{
                break;
            }
        }
      //right side counts
        for(int i=y+1;i<board.length;i++){
           if(board[x][i]!=1){
            board[x][i]=3;
                count++;
            }else{
                break;
            }
        }
        //left side counts
        for(int i=y-1;i>=0;i--){
            if(board[x][i]!=1){
                board[x][i]=3;
                count++;
            }else{
                break;
            }
        }
        int i=x-1,j=y+1;
        //right up diagonal
        while(i>=0 && j<board.length){
            if(board[i][j]==1){
                break;
            }
            board[i][j]=3;
            count++;
            i--;
            j++;
        }

        i=x+1;
        j=y+1;
        //right down diagonal
        while(i<board.length && j<board.length){
            if(board[i][j]==1){
                break;
            }
            board[i][j]=3;
            count++;
            i++;
            j++;
        }
        i=x-1;
        j=y-1;
        //left up diagonal
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                break;
            }
            board[i][j]=3;
            count++;
            i--;
            j--;
        }
        i=x+1;
        j=y-1;
        //left down diagonal
        while(i<board.length && j>=0){
            if(board[i][j]==1){
                break;
            }
            board[i][j]=3;
            count++;
            i++;
            j--;
        }
        for(int[] a:board){
            System.out.println(Arrays.toString(a));
        }
        return count;

    }
	public static void main(String[] args){
        int n=8,x=4,y=4;
        int k=2;
        int[] xpos={3};
        int[] ypos={5};
        int m=queenMoves(n,x,y,k,xpos,ypos);
        System.out.println(m);
    }
}