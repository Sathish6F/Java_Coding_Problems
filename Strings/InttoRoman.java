/*
Input: num = 3749
Output: "MMMDCCXLIX"
Explanation:
3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
*/
package Strings;
public class InttoRoman {
    public static String intToRoman(int num){
        StringBuffer sb=new StringBuffer();
        while(num>0){
            if(num>=1000){
                sb.append("M");
                num-=1000;
            }
            else if(num>=900 && num<1000){
                sb.append("CM");
                num-=900;
            }
            else if(num>=500 && num<900){
                sb.append("D");
                num-=500;
            }
            else if(num>=400 && num<500){
                sb.append("CD");
                num-=400;
            }
            else if(num>=100 && num<400){
                sb.append("C");
                num-=100;
            }
            else if(num>=90 && num<100){
                sb.append("XC");
                num-=90;
            }
            else if(num>=50 && num<90){
                sb.append("L");
                num-=50;
            }
            else if(num>=40 && num<50){
                sb.append("XL");
                num-=40;
            }
            else if(num>=10 && num<40){
                sb.append("X");
                num-=10;
            }
            else if(num==9){
                sb.append("IX");
                num-=9;
            }
            else if(num>=5 && num<9){
                sb.append("V");
                num-=5;
            }
            else if(num==4){
                sb.append("IV");
                num-=4;
            }
            else if(num>0 && num<4){
                sb.append("I");
                num--;
            }
        }
        return sb.toString();
    }
	public static void main(String[] args){
        int n=3749;
        System.out.println("The roman value is:"+intToRoman(n));
    }
}