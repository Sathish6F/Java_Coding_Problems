package Collections;

import java.util.NoSuchElementException;

public class PriorityQueue1{
	
    private Integer[] heap;
    private int n;
    private static final int DEFAULT_CAPACITY = 11;

    public PriorityQueue1(int capacity){
        heap =  new Integer[capacity+1];
        n = 0;
    }

    public PriorityQueue1(){
        this(DEFAULT_CAPACITY);
    }

    private void resize(int capacity){
        if(capacity < 1){
            throw new IllegalArgumentException();
        }
        Integer[] temp = new Integer[capacity];
        for(int i = 0;i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public boolean offer(Object obj){
        if(obj == null){
            throw new NullPointerException();
        }
        if(n == heap.length-1){
            resize(heap.length * 2);
        }
        n++;
        heap[n] = (Integer)obj;
        swim(n);
        return true;
    }

    private void swim(int k){
        while(k > 1 && (heap[k/2] > heap[k])){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    public int poll(){
        if( n == 0){
            throw new NoSuchElementException();
        }
        int min = heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n+1] = null;
       /* if(n > 0 && (n == (heap.length-1)/4)){
            resize(heap.length/2);
        }
        */
        return min;
    }

    private void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void sink(int k){
        while( 2*k <= n){
            int j = 2*k;
            if(j < n && heap[j] > heap[j+1]){
                j++;
            }
            if(heap[k] <= heap[j]){
                break;
            }
            swap(j,k);
            k = j;
        }
    }

    public int peek(){
        return heap[1];
    }

    public boolean contains(Object obj){
        for(int i = 1;i <= n; i++){
            if(heap[i] == obj){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i = 1; i <= n; i++){
            heap[i] = null;
        }
        n = 0;
    }

    public boolean isEmpty(){
        return (n == 0);
    }

    public int size(){
        return n;
    }

    public String toString(){
        if(n == 0){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for(int i = 1;i < n; i++){
            sb.append(heap[i]).append(',');
        }
        sb.append(heap[n]).append(']');
        return sb.toString();
    }

    public static void main(String[] args){
        PriorityQueue1 q = new PriorityQueue1();
        q.offer(450);
        q.offer(900);
        q.offer(900);
        q.offer(480);
        q.offer(470);
        q.offer(490);
        q.offer(460);
        q.offer(455);
        System.out.println(q);
        q.poll();
        System.out.println(q);
        
    }
}