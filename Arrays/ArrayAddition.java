package Arrays;

public class ArrayAddition {
    public static String arrayAddition(int[] a1,int[] a2){
        int i=a1.length-1,j=a2.length-1;
        int carry=0,temp=0;
        StringBuffer sb=new StringBuffer();
        while(i>=0 && j>=0){
            temp=a1[i]+a2[j]+carry;
            carry=0;
            if(temp>9 && i>0){
                sb.insert(0,temp%10);
                carry=temp/10;
            }
            else if(temp<=9){
                sb.insert(0,temp);
            }
            i--;
            j--;
        }
        while(i>=0){
            temp=a1[i]+carry;
            carry=0;
            if(temp>10){
                sb.insert(0,temp%10);
                carry=temp/10;
                i--;
            }
            else if(temp<=10){
                sb.insert(0,temp);
                i--;
            }
        }
        while(j>=0){
            temp=a2[j]+carry;
            carry=0;
            if(temp>10){
                sb.insert(0,temp%10);
                carry=temp/10;
                j--;
            }
            else if(temp<=10){
                sb.insert(0,temp);
                j--;
            }
        }
        return String.valueOf(sb.toString());
    }
	public static void main(String[] args){
        int[] a1={1,2,3};
        int[] a2={1,2};
        System.out.println("The addition is:"+arrayAddition(a1,a2));
    }
}