/*
program
              g
            gr
          gra
       gram
     gramp
   grampr
grampro
*/
package ZohoQues;
public class Pattern6 {
	public static void main(String[] args){
        String s="program";
        int mid=s.length()/2;
        int spaces=s.length()*2-2;
        int temp=0;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            int t=mid;
            for(int k=1;k<=i && t<s.length();k++){
                System.out.print(s.charAt(t++));
            }
            if(i>mid+1){
                for(int j=0;j<=temp;j++){
                    System.out.print(s.charAt(j));
                }
                temp++;
            }
            System.out.println();
            spaces-=2;
            
        }
    }
}