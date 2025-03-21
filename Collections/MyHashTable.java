package Collections;

public class MyHashTable<K,V> {
	
    private HashNode<K,V>[] buckets;
    private int size;
    private int capacity;

    MyHashTable(){
        this(10);
    }

    MyHashTable(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException();
        }
        buckets =(HashNode<K,V>[]) new HashNode[capacity];
        this.capacity = capacity;
    }

    private class HashNode<K,V>{
        K key;
        V value;
        HashNode<K,V> next;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key){
        return key != null ? Math.abs(key.hashCode()) % capacity : 0;
    }

    public void put(K key, V value) {
        if(key == null || value == null){
            throw new IllegalArgumentException() ;
        }
        int index = hash(key);
        HashNode<K,V> node = buckets[index];
    
        while(node != null) {
            if(node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        size++;
        node = buckets[index];
        HashNode<K,V> newNode = new HashNode<>(key, value);
        newNode.next = node;
        buckets[index] = newNode;
    
    }

    public V get(K key) {
        if(key == null){
            throw new IllegalArgumentException();
        }

        int index = hash(key);
        HashNode<K,V> node = buckets[index];
    
        while(node != null) {
            if(node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        if(key == null){
            throw new IllegalArgumentException();
        }
        
        int index = hash(key);
        HashNode<K,V> node = buckets[index];
        HashNode<K,V> prev = null;
    
        while(node != null) {
            if(node.key.equals(key)) {
                break;
            }
            prev = node;
            node = node.next;
        }
        if(node == null){
            return null;
        }
        size--;
        if(prev != null){
            prev.next = node.next;
        }
        else{
            buckets[index] = node.next;
        }
        return node.value;
    }

    public boolean contains(K key){
        int index = hash(key);
        HashNode<K,V> node = buckets[index];
        while(node != null){
            if(node.key.equals(key)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public int size() {
        return size;
    }

    public String toString(){
        if(size == 0){
            return "{}";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(int i = 0 ;i < buckets.length; i++){
            HashNode<K,V> current = buckets[i];
            while(current != null) {
                sb.append(current.key + " = " + current.value);
                if(current != null || i < capacity-1) {
                    sb.append(", ");
                }
                current = current.next;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args){
        MyHashTable<Integer,String> table = new MyHashTable<>();
        table.put(1,"ab");
        table.put(12,"SS");
        table.put(122,"cc");
        System.out.println(table);
        table.remove(122);
        System.out.println(table);
    }
}