package Arrays;
import java.util.*;
public class Arrays1 {

    public static List<Byte> asList(byte[] arr){
        List<Byte> list=new ArrayList<Byte>();
        for(byte b:arr){
            list.add(b);
        }
        return list;
    }

    public static List<Short> asList(short[] arr){
        List<Short> list=new ArrayList<Short>();
        for(short s:arr){
            list.add(s);
        }
        return list;
    }

	public static List<Integer> asList(int[] arr){
        List<Integer> list=new ArrayList<Integer>();
        for(int n:arr){
            list.add(n);
        }
        return list;
    }

    public static List<Long> asList(long[] arr){
        List<Long> list=new ArrayList<Long>();
        for(long n:arr){
            list.add(n);
        }
        return list;
    }

    public static List<Character> asList(char[] arr){
        List<Character> list=new ArrayList<Character>();
        for(char c:arr){
            list.add(c);
        }
        return list;
    }

    public static List<String> asList(String[] arr){
        List<String> list=new ArrayList<String>();
        for(String s:arr){
            list.add(s);
        }
        return list;
    }

    public static List<Float> asList(float[] arr){
        List<Float> list=new ArrayList<Float>();
        for(float f:arr){
            list.add(f);
        }
        return list;
    }
    public static List<Double> asList(double[] arr){
        List<Double> list=new ArrayList<Double>();
        for(double d:arr){
            list.add(d);
        }
        return list;
    }

    public static List<Boolean> asList(boolean[] arr){
        List<Boolean> list=new ArrayList<Boolean>();
        for(boolean b:arr){
            list.add(b);
        }
        return list;
    }

    public static void fill(byte[] arr,byte val){
        for(int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }

    public static void fill(byte[] arr,int start,int end,byte val){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=val;
        }
    }

    public static void fill(short[] arr,short val){
        for(int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }

    public static void fill(short[] arr,int start,int end,short val){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=val;
        }
    }

    public static void fill(int[] arr,int val){
        for(int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }

    public static void fill(int[] arr,int start,int end,int val){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=val;
        }
    }

    public static void fill(char[] arr,char c){
        for(int i=0;i<arr.length;i++){
            arr[i]=c;
        }
    }

    public static void fill(char[] arr,int start,int end,char c){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=c;
        }
    }

    public static void fill(boolean[] arr,boolean b){
        for(int i=0;i<arr.length;i++){
            arr[i]=b;
        }
    }

    public static void fill(boolean[] arr,int start,int end,boolean b){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=b;
        }
    }

    public static void fill(double[] arr,double d){
        for(int i=0;i<arr.length;i++){
            arr[i]=d;
        }
    }

    public static void fill(double[] arr,int start,int end,double d){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=d;
        }
    }

    public static void fill(String[] arr,String s){
        for(int i=0;i<arr.length;i++){
            arr[i]=s;
        }
    }

    public static void fill(String[] arr,int start,int end,String s){
        if(start>end){
            throw new IllegalArgumentException();
        }
        if(start<0 || end>arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i=start;i<end;i++){
            arr[i]=s;
        }
    }

    public static void sort(int[] arr){
        quicksort(arr,0,arr.length-1);
    }
    private static void quicksort(int[] arr,int start,int end){
        if(start<end){
        int pivot=partition(arr,start,end);
        quicksort(arr, start, pivot-1);
        quicksort(arr, pivot+1, end);
        }
    }
    private static int partition(int[] a,int start,int end){
        int pivot=end;
        int i=start-1;
        for(int j=start;j<end;j++){
            if(a[pivot]>a[j]){
                swap(a,++i,j);
            }
        }
        swap(a,i+1,end);
        return i+1;
    }
    private static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static String toString(int[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for(int n:arr){
            sb.append(n);
            sb.append(",");
        }
        sb.deleteCharAt(arr.length*2);
        sb.append("]");
        return sb.toString();
    }

    public static String toString(char[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for(char c:arr){
            sb.append(c);
            sb.append(",");
        }
        sb.deleteCharAt(arr.length*2);
        sb.append("]");
        return sb.toString();
    }

    public static String toString(byte[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for(byte b:arr){
            sb.append(b);
            sb.append(",");
        }
        sb.deleteCharAt(arr.length*2);
        sb.append("]");
        return sb.toString();
    }
    
    public static String toString(boolean[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for(boolean b:arr){
            sb.append(b);
            sb.append(",");
        }
        sb.deleteCharAt(arr.length*2);
        sb.append("]");
        return sb.toString();
    }

    public static String toString(double[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for(double d:arr){
            sb.append(d);
            sb.append(",");
        }
        sb.deleteCharAt(arr.length*2);
        sb.append("]");
        return sb.toString();
    }

    public static String toString(String[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for(String s:arr){
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(arr.length*2);
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args){
        int[] a={10,3,12,18,33,1,11,5};
        char[] arr={'c','a','t','d'};
        Arrays1.fill(arr,'r');
        System.out.println(Arrays1.asList(arr));
    }
}