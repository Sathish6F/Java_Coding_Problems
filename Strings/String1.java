package Strings;
import java.util.*;
public final class String1{
    private final char[] str;
    String1(){
        this.str = new char[]{' '};
    }
    String1(char[] str){
        this.str = str;
    }
    public int indexOf(char ch){  //1.IndexOf(char ch)
        for(int i = 0 ;i < this.str.length ;i++){
            if(this.str[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(char t){ //2.lastIndexOf(char t)
        for(int idx = this.str.length-1;idx >= 0;idx--){
            if(this.charAt(idx) == t){
                return idx;
            } 
        }
        return -1;
    }
    public char charAt(int idx){   //3.charAt(int idx)
        if(idx > this.str.length || idx < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.str[idx];
    }
    public String1 subString1(int start){ //4.subString1(int start)
        if(start < 0 || start > this.length()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char[] res = new char[this.length()-start];
        int i = 0;
        for(int idx = start;idx < this.length();idx++){
            res[i++] = this.charAt(idx);
        }
        return new String1(res);
    }
    public String1 subString1(int start,int end){ //5.SubString1(int start,int end)
        if(start > end){
            throw new IllegalArgumentException();
        }
        if(start == end){
            return new String1(new char[]{this.charAt(start)});
        }
        char[] res = new char[end-start];
        int i = 0;
        for(int idx = start;idx < end;idx++){
            res[i++] = this.charAt(idx);
        }
        return new String1(res);
    }
    public String1 toUpperCase(){ //6.toUpperCase()
        char[] res = new char[this.str.length];
        for(int i = 0;i < this.str.length;i++){
            if(this.charAt(i) >= 'a' && this.charAt(i) <= 'z'){
                res[i] = (char)(this.charAt(i)-32);
            }
            else{
                res[i] = this.charAt(i);
            } 
        }
        return new String1(res);
    }
    public String1 toLowerCase(){ //7.toLowerCase()
        char[] res = new char[this.str.length];
        for(int i = 0;i < this.str.length;i++){
            if(this.charAt(i) >= 'A' && this.charAt(i) <= 'Z'){
                res[i] = (char)(this.charAt(i)+32);
            }
           else{
                res[i] = this.charAt(i);
            } 
        }
        return new String1(res);
    }
    public String1 replace(char ch,char ch1){ //8.replace()
        char[] res = Arrays.copyOf(this.str, this.length());
        for(int i = 0;i < this.str.length;i++){
            if(this.charAt(i) == ch) res[i] = ch1;
        }
        return new String1(res);
    }
    public String1 trim(){//9.trim()
        int idx = 0;
        int start = 0,end = this.length()-1;
        while(this.str[start] == ' ') {
            start++;
        }
        while(this.str[end] == ' '){
            end--;
        }
        char[] res = new char[end-start+1];
        for(int i = start;i <= end;i++){
            res[idx++] = this.charAt(i);
        }
        return new String1(res);
    }
    public String1 concat(char[] c){ //10.concat(char[] c)
        char[] res = new char[this.length()+c.length];
        int idx = 0;
        for(int i = 0;i < this.length();i++) {
            res[idx++] = this.charAt(i);
        }
        for(int i = 0;i < c.length;i++) {
            res[idx++] = c[i];
        }
        return new String1(res);
    }
    public String1 concat(String1 s){ // 11.conact(String1 s)
        char[] res = new char[this.length()+s.length()];
        int idx = 0;
        for(int i = 0;i < this.length();i++) {
            res[idx++] = this.charAt(i);
        }
        for(int i = 0;i < s.length();i++) {
            res[idx++] = s.charAt(i);
        }
        return new String1(res);
    }
    public String toString(){ //12.toString()
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < this.length();i++){
            sb.append(this.charAt(i));
        }
        return sb.toString();
    }
    public int length(){ //13.length()
        return this.str.length;
    }
    public boolean equalsIgnoresCase(Object o){ //14.equalsIgnoresCase(Object o)
        if(!(o instanceof String1)){
            throw new ClassCastException();
        }
        String1 s=(String1)o;
        String1 s1=s.toLowerCase();
        String1 s2=this.toLowerCase();
        if(this.length()!=s.length()){
            return false;
        }
        
        for(int i=0;i<this.length();i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object o){ //15.equals(Object o)
        if(!(o instanceof String1)){
            throw new ClassCastException();
        }
        String1 s=(String1)o;
        char[] c=s.str;
        if(this.length()!=c.length){
            return false;
        }
        for(int i=0;i<this.length();i++){
            if(this.charAt(i) != c[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        String1 s=new String1(new char[]{'a','B','c','D','c'});
        String1 s1=new String1(new char[]{'A','B','c','d','c'});
        System.out.println(s.equalsIgnoresCase(s1));     
        System.out.println(s.equals(s1));
    }
        
}