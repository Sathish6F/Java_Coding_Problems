package Collections;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
public class ArrayList1<T> extends AbstractList<T> implements List<T>,Cloneable,Serializable,RandomAccess {
    private T[] arr;
    private int size = 0;
    private int modCount;
    
    @SuppressWarnings("unchecked")
    public ArrayList1(){
        this(10);
    }
    @SuppressWarnings("unchecked")
    public ArrayList1(int capacity){
        if(capacity < 0){
            throw new NegativeArraySizeException();
        }
        arr = (T[]) new Object[capacity];
    }
    @SuppressWarnings("unchecked")
    public ArrayList1(Collection<? extends T> c){
        modCount++;
        arr = (T[]) new Object[c.size()];
        for(Object o:c){
            arr[size++] = (T)o;
        }
    }
    @SuppressWarnings("unchecked")
    private void createNewArray(){
        T[] temp = (T[]) new Object[(size*3/2)+1];
        for(int i = 0 ;i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public boolean add(T obj){
        if(size == arr.length){
            createNewArray();
        }
        modCount++;
        arr[size++] = obj;
        return true;
    }

    public void add(int idx,Object o){
        if(idx < 0 || idx > size){
            throw new IllegalArgumentException();
        }
        if(size-1 == idx){
            createNewArray();
        }
        modCount++;
        for(int i = this.size()-1;i >= idx; i--){
            arr[i+1] = arr[i];
        }
        arr[idx] = (T)o;
        size++;
    }

    public boolean addAll(Collection<? extends T> c){
        if(c == null){
            throw new NullPointerException();
        }
        if(c.size() > arr.length){
            createNewArray();
        }
        for(Object obj : c){
            add((T)obj);
        }
        return true;
    }

    public T get(int index) {
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    public int indexOf(Object o){
        if(!this.contains(o)){
            return -1;
        }
        int idx = 0;
        for(T obj: arr){
            if(obj.equals(o)){
                return idx;
            }
            else{
                idx++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o){
        
        for(int i = size-1; i >= 0; i--){
            if(arr[i] == o){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){

        if(obj == null){
            for(int i = 0;i < this.size(); i++){
                if(arr[i] == null){
                    return true;
                }
            }
        }
        else{
            for(int i = 0;i < this.size(); i++){
                if(arr[i].equals(obj)){
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean remove(Object obj){

        if(!this.contains(obj)){
            throw new NoSuchElementException();
        }
        modCount++;
        int i=0;
        for(i=0;i<this.size();i++){
            if(arr[i] == obj){
                break;
            }
        }
        for( ;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[size-1]=null;
        size--;
        return true;

    }

    public T remove(int index){

        if(index < 0 || index > size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        modCount++;
        T obj=get(index);
        for(int i=index;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        size--;
        return obj;

    }

    public void removeRange(int from,int to){

        if(from > size || from < 0 || to > size || to < from){
            throw new IndexOutOfBoundsException();
        }
        modCount++;
        int idx=to;
        for(int i=from;i<to && idx < size;i++){
            arr[i]=arr[idx++];
        }
        for(int i=size-1;i>=(to-from);i--){
            arr[i]=null;
            size--;
        }

    }

    public List<T> subList(int start,int end){

        if(start > size || start< 0 || end > size || end < start){
            throw new IndexOutOfBoundsException();
        }
        T[] element = (T[])new Object[end-start];
        int index = 0;
        for(int i=start;i<end;i++){
            element[index++] = arr[i];
        }
        return new ArrayList1<>(Arrays.asList(element));

    }

    public T set(int index,Object obj){

        if(index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        T val = get(index);
        arr[index]= (T) obj;
        return val;
    }

    public Object[] toArray(){
        Object[] objArr = new Object[size];
        for(int i=0 ;i<size;i++){
            objArr[i]=arr[i];
        }
        return objArr;
    }

    public void clear(){
        modCount++;
        for(T o:arr){
            o = null;
        }
        size = 0;

    }

    public void trimToSize(){

        T[] newArr = (T[]) new Object[size];
        for(int i=0 ;i<size ;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;

    }

    public Iterator<T> iterator(){
        return new Itr();
    }
    @SuppressWarnings("hiding")
    private class Itr<T> implements Iterator<T>{
        
        int expectedModcount = modCount;
        int cursor;
        int lastret = -1;
        public boolean hasNext(){
            return cursor != size; 
        }
        Itr(){}
        public T next() {
            checkModification();
            int i = cursor;
            if(i >= size){
                throw new NoSuchElementException();
            }
            T[] element = (T[]) ArrayList1.this.arr;
            if(i > element.length){
                throw new ConcurrentModificationException();
            }
            cursor = i+1;
            lastret = i;
            return (T)arr[lastret];
        }

        public void remove(){
            if(lastret < 0){
                throw new IllegalStateException();
            }
            checkModification();
            try{
                ArrayList1.this.remove(lastret);
                cursor = lastret;
                lastret = -1;
                expectedModcount = modCount;
            }
            catch(ArrayIndexOutOfBoundsException e){
                throw new ConcurrentModificationException();
            }
        }
        private void checkModification(){
            if(expectedModcount != modCount){
                throw new ConcurrentModificationException();
            }
        }

    }
    public boolean isEmpty(){
        return (size == 0);
    }

    public int size() {
        return size;
    }


    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            if(i==size-1){
                sb.append(arr[i]);
            }
            else{
                sb.append(arr[i]);
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        ArrayList1<String> l1=new ArrayList1<>(Arrays.asList("a","b","c","a","b","e","a","b","e","a"));
        System.out.println(l1);
        l1.add("z");
        l1.set(3,"x");
        System.out.println(Arrays.toString(l1.toArray()));
        l1.addAll(new ArrayList1<>(Arrays.asList("1","2","3")));
        Iterator itr = l1.iterator();
        System.out.println(l1);
        while(itr.hasNext()){
            if(itr.next().equals("a")){
                itr.remove();
            }
        }
        
        System.out.println(l1);
    }
    
    
}