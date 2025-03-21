package Strings;
final public class StringBuffer1 {
	private char[] str;
    int start=0;
    //Empty constructor default size 16
    StringBuffer1(){
        this.str=new char[16];
    }
    //Custom buffer size
    StringBuffer1(int size){
        if(size<0){
            throw new IllegalArgumentException();
        }
        this.str=new char[size];
    }
    //create the StringBuffer1 object for given String
    StringBuffer1(String s){
        this.str=new char[s.length()*2];
            int i=0;
            for(int j=0;j<s.length();j++){
                this.str[i++]=s.charAt(j);
            }
    }
    //Creates the StringBuffer1 object for given char[]
    StringBuffer1(char[] c){
        this.str=c;
    }

    public char charAt(int idx){
        if(idx<0 || idx>this.str.length){
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        return this.str[idx];
    }

    public void setCharAt(int idx,char ch){
        if(idx<0 || idx>this.capacity()){
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        this.str[idx]=ch;
    }
    
    public StringBuffer1 append(char c){
       if(this.start==this.str.length){
            char[] temp=new char[this.length()*2];
            int i;
            for(i=0;i<this.str.length;i++){
                temp[i]=this.charAt(i);
            }
            this.str=temp;
            this.start=i;
        }
        else if(this.length()>0 && this.length()<this.str.length){
            this.start=this.length();
        }
        this.str[this.start++]=c;
        return this;
    }

    public StringBuffer1 append(String s){
        for(int i=0;i<s.length();i++){
            this.append(s.charAt(i));
        } 
        return this;
    }

    public StringBuffer1 append(char[] c){
        for(int i=0;i<c.length;i++){
            this.append(c[i]);
        }
        return this;
    }

    public StringBuffer1 append(boolean bool){
        return (bool)?this.append("true"):this.append("false");
    }

    public StringBuffer1 append(int i){
        if(this.start==this.str.length){
            char[] temp=new char[this.length()*2];
            int idx;
            for(idx=0;idx<this.str.length;idx++){
                temp[idx]=this.charAt(idx);
            }
            this.str=temp;
            this.start=idx;
        }
        if(this.length()>0 && this.length()<this.str.length){
            this.start=this.length();
        }
        if(i<=9){
            this.str[start++]=(char)(i+48);
        }
        if(i>9){
                int cnt=0;
                int tem=i;
                while(tem!=0){
                    cnt++;
                    tem/=10;  
                }
                int j=0;
                int[] temp=new int[cnt];
                while(i!=0){
                    temp[j++]=i%10;
                    i=i/10;
                }
                j--;
                while(j>=0){
                    this.append(temp[j--]);
                }
        }
        return this;
    }

    public StringBuffer1 insert(int idx,char c){
        if(idx<0 || idx>this.length()){
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        for(int i=this.length()+1;i>=idx;i--){
            this.str[i]=this.str[i-1];
        }
        this.str[idx]=c;
        return this;
    }

    public StringBuffer1 reverse(){
        int start=0;
        int end=this.length()-1;
        while(start<=end){
            char t=this.str[start];
            this.str[start]=this.str[end];
            this.str[end]=t;
            start++;
            end--;
        }
        return this;
    }

    public String subString(int idx){
        if(idx<0 || idx>this.length()){
            throw new StringIndexOutOfBoundsException();
        }
        StringBuffer1 sb=new StringBuffer1();
        for(int i=idx;i<this.length();i++){
            sb.append(this.charAt(i));
        }
        return sb.toString();
    }
    
    public String subString(int start,int end){
        if(start<0 || start>this.length() || end<0 || end>this.length()){
            throw new StringIndexOutOfBoundsException();
        }
        if(start>end){
            throw new IllegalArgumentException("Start index must be smaller than End index");
        }
        StringBuffer1 sb=new StringBuffer1();
        for(int i=start;i<end;i++){
            sb.append(this.charAt(i));
        }
        return sb.toString();
    }

    public StringBuffer1 deleteCharAt(int idx){
        if(idx<0 || idx>this.capacity()){
            throw new ArrayIndexOutOfBoundsException(idx);
        }       
        for(int i=idx;i<this.str.length-1;i++){
            str[i]=str[i+1];
        }
        return this;
    }
    
    public int indexOf(String s){
        int start=0;
        for(int i=0;i<this.length();i++){
            if(s.charAt(start)==this.charAt(i)){
                boolean flag=true;
                start++;
                for(int j=i+1;j<this.length() && start<s.length();j++){
                    if(s.charAt(start++)!=this.charAt(j)){
                        start=0;
                        flag=false;
                        break;
                    }
                }
                if(flag && start==s.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public int indexOf(String s,int idx){
        int start=0;
        for(int i=idx;i<this.length();i++){
            if(s.charAt(start)==this.charAt(i)){
                boolean flag=true;
                start++;
                for(int j=i+1;j<this.length() && start<s.length();j++){
                    if(s.charAt(start++)!=this.charAt(j)){
                        start=0;
                        flag=false;
                        break;
                    }
                }
                if(flag && start==s.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(String s){
        int start=0;
        for(int i=this.length()-1;i>=0;i--){
            if(s.charAt(start)==this.charAt(i)){
                boolean flag=true;
                start++;
                for(int j=i+1;j<this.length() && start<s.length();j++){
                    if(s.charAt(start++)!=this.charAt(j)&& start<s.length()){
                        start=0;
                        flag=false;
                        break;
                    }
                }
                if(flag && start==s.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(String s,int idx){
        int start=0;
        for(int i=this.length()-1;i>=idx;i--){
            if(s.charAt(start)==this.charAt(i)){
                boolean flag=true;
                start++;
                for(int j=i+1;j<this.length() && start<s.length();j++){
                    if(s.charAt(start++)!=this.charAt(j)&& start<s.length()){
                        start=0;
                        flag=false;
                        break;
                    }
                }
                if(flag && start==s.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public int capacity(){
        return this.str.length; 
    }

    public int length(){
        int cnt=0;
        for(int i=0;i<this.str.length;i++){
            if(this.charAt(i)!=0){
                cnt++;
            }
        }
        return (cnt==0)?this.str.length:cnt;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<this.length();i++){
            if(this.charAt(i)!=0){
                sb.append(this.charAt(i));
            }
           else if(this.charAt(i)==' '){
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public boolean equals(Object o){
        if(! (o instanceof StringBuffer1)){
            throw new ClassCastException();
        }
        return this==o;
    }

    public static void main(String[] args) {
        StringBuffer1 sb=new StringBuffer1();
        sb.append("hllo Surendhr");
        sb.append(230);
        sb.append(true);
        sb.append(new char[]{'a'});
        System.out.println(sb); 
        sb.deleteCharAt(0);
        sb.deleteCharAt(5);
        sb.deleteCharAt(0);
        sb.insert(8,'r');
        sb.reverse();
        System.out.println(sb); 
        sb.reverse();
        System.out.println(sb);  
        System.out.println(sb.indexOf("Surendhr"));   
        System.out.println(sb.subString(3,8)); 
        System.out.println(sb.indexOf(" ")); 
        System.out.println(sb.length());

    }
}