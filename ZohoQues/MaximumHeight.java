package ZohoQues;
/*
You are given two integers red and blue representing the count of red and blue colored balls. You have to arrange these balls to form a triangle such that the 1st row will have 1 ball, the 2nd row will have 2 balls, the 3rd row will have 3 balls, and so on.
All the balls in a particular row should be the same color, and adjacent rows should have different colors.
Return the maximum height of the triangle that can be achieved.
Example 1:
Input: red = 2, blue = 4
Output: 3
*/
public class MaximumHeight {
    public static int findMaxHeight(int red,int blue){
        if(red == 1 && blue ==1){
            return 1;
        }
        return Math.max(height(red,blue),height(blue,red));
    }
    static int height(int ball1,int ball2){
        int row = 1;
        int cnt = 0;
        char c= '1';
        while(ball1>=row || ball2>=row){
            if(c=='1' && ball1>=row){
                ball1 -= row;
                row++;
            }
            else if(c=='2' && ball2>=row){
                ball2 -= row;
                row++;
            }else{
                break;
            }
            c = (c=='1')?'2':'1';
            cnt++;
        }
        return cnt;
    }
	public static void main(String[] args){
        int red = 10;
        int blue = 1;
        System.out.println(findMaxHeight(red,blue));
    }
}