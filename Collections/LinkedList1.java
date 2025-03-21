package Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList1<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size=0;
    private int modCount;
    LinkedList1(){
        this.head = null;
        this.tail = null;
    }

    LinkedList1(Collection<? extends T> c){
        if(c == null){
            throw new NullPointerException();
        }
        for(Object obj : c){
            this.add(obj);
        }
    }

	@SuppressWarnings("hiding")
    private class Node<T>{
        T data;
        Node<T> previous;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }

    public boolean add(Object obj){
        return addLast(obj);  
    }

    public void add(int index,Object obj){
        if(index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        modCount++;
        if(index == 0){
            addFirst(obj);
            return;
        }
        if(index == size-1){
            addLast(obj);
            return;
        }
        int count = 0;
        Node<T> current = head;
        while(count < index-1){
            count++;
            current = current.next;
        }
        Node<T> newNode = new Node<>((T)obj);
        newNode.next = current.next;
        current.next = newNode;
        newNode.previous = current;
        size++;
    }

    public boolean addFirst(Object obj){
        modCount++;
        Node<T> newNode = new Node<>((T) obj);
        if(isEmpty()){
            tail = newNode;
        }
        else{
           head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public boolean addLast(Object obj){
        modCount++;
        Node<T> newNode = new Node<>((T) obj);
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        size++;
        return true;
    }

    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(head == null){
            throw new NoSuchElementException();
        }
        modCount++;
        int count = 0;
        Node<T> curr = head;
        Node<T> prev = null;
        while(count <= index -1){
            count++;
            prev = curr;
            curr = curr.next;
        }
        Node<T> temp = curr;
        prev.next = curr.next;
        curr.next.previous = prev;
        return temp.data;
    }

    public void remove(T obj){
        if(head == null){
            throw new NoSuchElementException();
        }
        modCount++;
        if(head.next == null){
            head = null;
            size--;
            return;
        }else{
            Node<T> curr = head;
            Node<T> prev = null;
            while(curr != null){
                if(curr.data.equals(obj)){
                    prev.next =  curr.next;
                    curr.next.previous = prev;
                    curr.next = null;
                    curr.previous = null;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public T removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        modCount++;
        if(head.next == null){
            Node<T> temp = head;
            head = null;
            size--;
            return temp.data;
        }
        Node<T> temp = head;
        head.next.previous = null;
        head = head.next;
        size--;
        return temp.data;

    }

    public T removeLast(){
        if(head == null){
            throw new NoSuchElementException();
        }
        modCount++;
        Node<T> temp = tail;
        if(head.next == null){
           head = null;
           size--;
           return temp.data;
        }else{
            tail.previous.next = null;
            tail = tail.previous;
            tail.next= null;
        }
        size--;
        return temp.data;
    }

    public boolean contains(Object obj){
        Node<T> current = head;
        while(current != null){
            if(current.data.equals(obj)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T element(){
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public T getFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }
    
    public T getLast(){
        if(head == null){
            throw new NoSuchElementException();
        }
        if(head == tail){
            return getFirst();
        }
        return tail.data;
    }

    public T get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        if(index == 0){
            return getFirst();
        }
        if(index == size-1){
            return getLast();
        }
        int count = 0;
        Node<T> current = head;
        while(count < index ){
            count++;
            current = current.next;
        }
        return current.data;
    }

    public int indexOf(Object obj){
        if(head == null){
            throw new NoSuchElementException();
        }
        int index = 0;
        Node<T> current = head;
        while(current != null){
            if(current.data.equals(obj)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj){
        if(head == null){
            throw new NoSuchElementException();
        }
        int index = size-1;
        Node<T> current = tail;
        while(current != null){
            if(current.data.equals(obj)){
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    public boolean offer(Object obj){
        return addLast(obj);
    }

    public boolean offerFirst(Object obj){
        return addFirst(obj);
    }

    public boolean offerLast(Object obj){
        add(size,obj);
        return true;
    }

    public void clear(){
        Node<T> current = head;
        while(current != null){
            current.data = null;
            current = current.next;
        }
        size = 0;
    }

    public Iterator<T> iterator(){
        return new Itr<>();
    }
    private class Itr<T> implements Iterator<T>{
        Itr(){

        }
        private int expectedModCount = modCount;
        private int cursor;
        private int lastret = -1;

        public boolean hasNext(){
            return cursor != size;
        }

        public T next(){
            checkModification();
            int i = cursor;
            if(i >= size){
                throw new NoSuchElementException();
            }
            cursor = i+1;
            lastret = i;
            return (T)get(lastret);
        }
        
        public void remove(){
            if(lastret < 0){
                throw new IllegalStateException();
            }
            checkModification();
            try{
                LinkedList1.this.remove(lastret);
                cursor = lastret;
                lastret = -1;
                expectedModCount = modCount;
            }
            catch(NoSuchElementException e){
                throw new ConcurrentModificationException();
            }
        }
        private void checkModification(){
            if(expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
        }

    }
    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public String toString(){
        if(head == null){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        Node<T> current = head;
        sb.append('[');
        while(current.next != null){
            sb.append(current.data).append(',');
            current = current.next;
        }
        sb.append(current.data).append(']');
        return sb.toString();
    }

    public static void main(String[] args){
        LinkedList1<Integer> list = new LinkedList1<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        System.out.println(list);
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            if(itr.next() == 4){
                itr.remove();
            }
        }
        System.out.println(list);
    }
}