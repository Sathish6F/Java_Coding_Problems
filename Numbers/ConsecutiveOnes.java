package Numbers;
//count consecutive ones in a binary number
public class ConsecutiveOnes {
    static int countConsecutive(int n){
        int count=0;
        while(n>0){
            n = n & (n<<1);
            count++;
        }
        return count;
    }
	public static void main(String[] args){
        int n=73;
        System.out.println(countConsecutive(n));
    }
}