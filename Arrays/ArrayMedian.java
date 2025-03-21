package Arrays;
import java.util.Scanner;
public class ArrayMedian {
    public static double arrayMedian(int[] a,int[] b){
        int m1=-1;
        int m2=-1;
        int i=0,j=0;
        for(int k=0;k<=(a.length+b.length)/2;k++){
            m2=m1;
            if(i!=a.length && j!=b.length)
                m1=(a[i]>b[j])?b[j++]:a[i++];
            else if(i<a.length)
                m1=a[i++];
            else
                m1=b[j++];
        }
        if((a.length+b.length)%2==1) return (double)m1;
        return (double)(m1+m2)/2;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Enter second array size:");
        int m=sc.nextInt();
        int[] b=new int[m];
        System.out.println("Enter array elements");
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }
        double median=arrayMedian(a,b);
        System.out.println("The array median is:"+median);
    }
}