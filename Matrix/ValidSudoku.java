/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according 
to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/
package Matrix;
public class ValidSudoku {
    public static boolean checkRow(String[][] board,int row){
        int[] hash=new int[10];
        for(int i=0;i<board[0].length;i++){
            if(board[row][i].equals(".")) continue;
            else hash[board[row][i].charAt(0)-'0']++;
        }
        for(int i=1;i<hash.length;i++)
            if(hash[i]>1) return false;
        return true;
    }
    public static boolean checkCol(String[][] board,int col){
        int[] hash=new int[10];
        for(int i=0;i<board.length;i++){
            if(board[i][col].equals(".")) continue;
            else hash[board[i][col].charAt(0)-'0']++;
        }
        for(int i=1;i<hash.length;i++)
            if(hash[i]>1) return false;
        return true;
    }
    public static boolean checkBox(String[][] board,int row,int col){
        int[] hash=new int[10];
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j].equals(".")) continue;
                else hash[board[i][j].charAt(0)-'0']++;
            }
        }
        if(hash[0]==1) return false;
        for(int i=1;i<hash.length;i++){
            if(hash[i]>1) return false;
        }
        return true;
    }
   
    public static boolean checkValid(String[][] board){
        for(int i=0;i<board.length;i++){
            if(!checkRow(board,i)) return false;
        }
        for(int j=0;j<board[0].length;j++){
            if(!checkCol(board,j)) return false;
        }
        int i=0,j=0;
        while(i<board.length){
            j=0;
            while(j<board[0].length){
                if(!checkBox(board,i,j)) return false;
                else j+=3;
            }
            i+=3;
        }
        return true;
    }
	public static void main(String[] args){
        String[][] board={{"5","3",".",".","7",".",".",".","."}
                         ,{"6",".",".","1","9","5",".",".","."}
                         ,{"4",".",".","8",".","3",".",".","1"}
                         ,{".","9","8",".",".",".",".","6","."}
                         ,{"8",".",".",".","6",".",".",".","3"}
                         ,{"7",".",".",".","2",".",".",".","6"}
                         ,{".","6",".",".",".",".","2","8","."}
                         ,{".",".",".","4","1","9",".",".","5"}
                         ,{".",".",".",".","8",".",".","7","9"}};
        System.out.println(checkValid(board));

    }
}