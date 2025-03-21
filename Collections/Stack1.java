package Collections;

import java.util.NoSuchElementException;

public class Stack1<T> {
	
    private Node top;
    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }

    public boolean push(Object obj){
        if(top == null){
            top = new Node((T) obj);
            return true;
        }
        Node temp = new Node((T) obj);
        temp.next = top;
        top = temp;
        return true;
    }
    
    public Object pop(){
        if(top == null){
            throw new NoSuchElementException();
        }
        if(top.next == null){
            T data = top.data;
            top = null;
            return data;
        }
        else{
            T data = top.data;
            top = top.next;
            return data;
        }
    }

    public Object peek(){
        return top.data;
    }

    public int search(Object obj){
        int offset=0;
        Node current = top;
        while(current != null){
            if(current.data == obj){
                return offset;
            }
            current = current.next;
            offset++;
        }
        return -1;
    }
    
    public boolean isEmpty(){
        return (top == null);
    }
    
    public String toString(){
        if(top == null){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        Node current = top;
        while(current.next != null){
            sb.append(current.data).append(',');
            current = current.next;
        }
        sb.append(current.data).append(']');
        return sb.toString();
    }

    public static void main(String[] args){
        Stack1<Integer> stk = new Stack1<>();
        stk.push(10);
        stk.push(20);
        stk.push(40);
        stk.push(50);
        System.out.println(stk);
        System.out.println(stk.pop());
        System.out.println(stk);
        System.out.println(stk.search(20));
        
    }

}