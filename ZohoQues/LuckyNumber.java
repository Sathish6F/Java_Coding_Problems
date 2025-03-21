package ZohoQues;

public class LuckyNumber {
    public static boolean isLucky(int n,int counter){
        if(n < counter){
            return true;
        }
        if(n % counter == 0){
            return false;
        }
        return isLucky(n-(n/counter), counter+1);
    }
	public static void main(String[] args){
        System.out.println(isLucky(7,2));
    }
}