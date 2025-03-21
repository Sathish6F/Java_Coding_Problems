package ZohoQues;
/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

*/
import java.util.*;
public class NQueens {

    public static boolean isSafe(int n,char[][] board,int r ,int c){
        for(int i = 0 ; i < n; i++){
            if(board[i][c] == 'Q'){
                return false;
            }
        }
        for(int i = r-1, j = c-1; i >=0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = r-1, j = c+1; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void solveNqueens(int n, char[][] board,List<List<String>> res, int r){
        if(r == n){
            ArrayList<String> list = new ArrayList<>();
            for(char[] b : board){
                list.add(new String(b));
            }
            res.add(list);
            return;
        }
        for(int c = 0; c < n; c++){
            if(isSafe(n,board,r,c)){
                board[r][c] = 'Q';
                solveNqueens(n, board, res, r+1);
                board[r][c] = '.';
            }
        }
    }
    public static List<List<String>> nQueens(int n){
        char[][] board = new char[n][n];
        for(char[] b : board){
            Arrays.fill(b,'.');
        }
        List<List<String>> res = new ArrayList<>();
        solveNqueens(n,board,res,0);
        return res;
    }
	public static void main(String[] args){
        int n = 5;
        List<List<String>> res = nQueens(n);
        System.out.println(res);
    }
}