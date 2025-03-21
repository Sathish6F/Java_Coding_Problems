package Collections;

import java.util.NoSuchElementException;

public class Arraydeque<T> {

    private int head = 0;
    private int tail = 0;
    private final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size = 0;
    @SuppressWarnings("unchecked")
    Arraydeque(){
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    Arraydeque(int capacity){
        if(capacity < 0){
            throw new NegativeArraySizeException();
        }
        else{
            elements = (T[]) new Object[capacity];
        }
    }
    
    private void grow(){
        T[] meta_data = (T[])new Object[(elements.length * 2)];
        for(int i = 0; i < size ;i++){
            meta_data[i] = elements[i];
        }
        elements = meta_data;

    }

    public boolean add(Object obj){
        if(tail == elements.length-1){
            grow();
        }
        if(size == 0){
            elements[head] = (T) obj;
            tail = head;
            size++;
            return true;
        }
        else{
            elements[tail+1] = (T) obj;
            size++;
            tail = tail+1;
        }
        return true;
    }

    public void addLast(Object obj){
        add(obj);
    }

    public void addFirst(Object obj){
        if(tail == elements.length){
            grow();
        }
        for(int i= size-1; i >= 0 ;i--){
            elements[i+1] = elements[i];
        }
        elements[head] = (T) obj;
        tail++;
        size++;
    }

    public boolean contains(Object obj){
        for(int i = head; i<= tail; i++){
            if(elements[i].equals(obj)){
                return true;
            }
        }
        return false;
    }

    public boolean offer(Object obj){
        addLast(obj);
        return true;
    }

    public boolean offerFirst(Object obj){
        addFirst(obj);
        return true;
    }

    public boolean offerLast(Object obj){
        return add(obj);
    }

    public T peek(){
        if(size == 0){
            return null;
        }
        return elements[head];
    }

    public T peekFirst(){
        if(size == 0){
            return null;
        }
        return elements[head];
    }
    
    public T peekLast(){
        if(size == 0){
            return null;
        }
        return elements[tail];
    }

    public T element(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return elements[head];
    }

    public T getFirst(){
        return element();
    }

    public T getLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        return elements[tail];
    }

    public T poll(){
        T result = elements[head];
        for(int i = 0;i < size;i++){
            elements[i] = elements[i+1];
        }
        tail--;
        return result;
    }

    public T pollFirst(){
        return poll();
    }

    public T pollLast(){
        T result = elements[tail];
        elements[tail] = null;
        tail--;
        return result;
    }

    public T remove(){
        if(size == 0){
            return null;
        }
        return poll();
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        return pollFirst();
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        return pollLast();
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public String toString(){
        if(size == 0){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = head; i < tail ;i++){
            sb.append(elements[i]).append(',');
        }
        sb.append(elements[tail]).append(']');
        return sb.toString();
    }
    public static void main(String[] agrs){
        Arraydeque<String> queue = new Arraydeque<>(5);
        queue.add("abc");
        queue.add("def");
        queue.add("ghi");
        System.out.println(queue);
        System.out.println(queue.size());
        queue.addFirst("first");
        queue.addLast("last");
        queue.add("six");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.pollFirst());
        System.out.println(queue);
        System.out.println(queue.pollLast());
        System.out.println(queue);
    }

}