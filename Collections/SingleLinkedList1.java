package Collections;

import java.io.Serializable;
import java.util.AbstractSequentialList;

public class SingleLinkedList1<T> extends AbstractSequentialList implements Serializable,Cloneable{
    
    private  Node head;
    private class Node{
        private T data;
        private Node next;
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
	
    public boolean add(Object obj){
       
        Node newNode = new Node((T)obj);
        if(head==null){
            head=newNode;
            return true;
        }
        Node current=head;
        while(null!=current.next){
            current=current.next;
        }
        current.next=newNode;
        return true;
    }

    public void add(int index,Object obj){
        if(index<0 || index>size()){
            throw new IllegalArgumentException();
        }
        Node newNode=new Node((T)obj);
        if(index==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        else{
            Node prev=head;
            int count=0;
            while(count<index){
                prev=prev.next;
                count++;
            }
            newNode.next=prev.next;
            prev.next=newNode;  
        }
        return;
    }
    public boolean addFirst(T o){
        Node newNode=new Node(o);
        newNode.next=head;
        head=newNode;
        return true;
    }
    
    public boolean addLast(Object o){
       return add(o);
    }

    public T removeFirst(){
        if(head==null){
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;

        return temp.data;
    }

    public T remove(){
        return removeFirst();
    }

    public T remove(int index){
        if(index<0 || index>size()){
            throw new IllegalArgumentException();
        }
        if(index==0){
            return removeFirst();
        }
        Node prev=head;
        int count=0;
        while(count<index){
            prev=prev.next;
            count++;
        }
        
        Node temp=prev.next;
        T data= temp.data;
        prev.next=temp.next;
        temp=null;
        return data;
    } 
    public boolean remove(Object obj){
        Node curr=head;
        int idx=0;
        while(curr.next!=null){
            if(curr.data == obj){
                remove(idx-1);
                return true;
            }else{
                idx++;
                curr=curr.next;
            }
        }
        if(curr.data==obj){
            remove(idx-1);
            return true;
        }
        return false;
    }
    
    public boolean contains(Object obj){
        Node current=head;
        while(current != null){
            if(current.data == obj){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public String toString(){
        StringBuffer sb= new StringBuffer();
        Node curr=head;
        sb.append("[");
        while(curr.next!=null){
            sb.append(curr.data).append(',');
            curr=curr.next;
        }
        sb.append(curr.data).append("]");
        return sb.toString();
    } 
    public int size(){
        int size=1;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args){
        SingleLinkedList1<String> list= new SingleLinkedList1<>();
        list.add("run");
        list.add("bun");
        list.add("bun");
        list.addFirst("gun");
        list.addLast("nun");
        System.out.println(list);
        System.out.println(list.remove("bun"));
        System.out.println(list);
        System.out.println(list.contains("nun"));
        System.out.println(list.contains("obj"));

    }
}