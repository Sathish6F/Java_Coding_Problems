package Strings;
public class NameRotation {

    public static int isPerfect(int n){
        for(int i = 1;(i*i) <= n;i++){
            if((i*i)==n){
                return i;
            }
        }
        return -1;
    }

    public static void rotate(String s,int n){
        char[][] mat = new char[n][n];
        int i = 0;

        for(int j = 0;j<mat.length;j++){
            for(int k = 0;k < mat.length && i < s.length();k++){
                mat[j][k] = s.charAt(i++);
            }
            System.out.println(mat[j]);
        }
        System.out.println();
        for(int row = 0;row < n;row++){
            for(int col = row;col < n;col++){
                char c = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] =c;
            }
            System.out.println(mat[row]);
        }
    }
	public static void main(String[] args){
        String s ="Sakthivenkateshivenkatesh";
        int n = isPerfect(s.length());
        if(n==-1){
            System.out.println("Failed");
            return;
        }else{
            rotate(s,n);
        }
    }
}