/*
You are given a string containing characters A and B only.
Your task is to change it into a string such that there are no matching adjacent 
characters. To do this, you are allowed to delete zero or more characters in the string.
Your task is to find the minimum number of required deletions.
i/p:AAAA
o/p:3
*/
package ZohoQues;
public class AlternatingCharacters {
    public static int alternatingCharacters(String s){
        int cnt=0;
        int i=0,j=1;
        StringBuffer sb=new StringBuffer();
        while(j<s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                sb.append(s.charAt(i));
                i=j++;
            }
            else{
                cnt++;
                j++;
            }
        }
        sb.append(s.charAt(i));
        System.out.println(sb.toString());

        return (j==sb.length())?0:cnt;
    }

	public static void main(String[] args){
        String s="AAAAA";
        System.out.println(alternatingCharacters(s));
    }
}