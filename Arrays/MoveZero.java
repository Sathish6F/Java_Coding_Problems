package Arrays;
import java.util.Arrays;
public class MoveZero {
    public static void moveZero(int[] a){
        int j=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0 && a[j]==0){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
            if(a[j]!=0){
                j++;
            }
        }
    }
	public static void main(String[] args){
        int[] a={0,1,0,10,9,0,0,2};
        System.out.println(Arrays.toString(a));
        moveZero(a);
        System.out.println("After moving zeros:");
        System.out.println(Arrays.toString(a));
    }
}