package Collections;

public class MyHashSet<K>{

    private MyHashTable<K,Object> buckets;
    private static final Object PRESENT = new Object();
    private static final int DEFAULT_CAPACITY = 16;

    public MyHashSet(){
        buckets = new MyHashTable<>(DEFAULT_CAPACITY);
    }

    public MyHashSet(int capacity){
        buckets = new MyHashTable<>(capacity);
    }
    
    public boolean add(K key){
        buckets.put(key,PRESENT);
        return true;
    }

    public boolean remove(K key){
       return buckets.remove(key) == PRESENT;
    }

    public boolean contains(K key){
        return buckets.contains(key);
    }

    public int size(){
        return buckets.size();
    }


    public String toString(){
        StringBuffer sb = new StringBuffer(buckets.toString());
        int left = 0,right = 0;
        while(left < sb.length()){
            if(sb.charAt(left) == '='){
                right = left +1;
                while(right < sb.length()){
                    if(sb.charAt(right) == ','){
                        break;
                    }
                    right++;
                }
                sb.delete(left, right);
                left = 0;
            }else if(left == sb.length()-1){
                break;
            }else{
                left++;
            }
            
        }
        sb.delete(sb.length()-4,sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args){
        MyHashSet<String> set = new MyHashSet<>();
        set.add("abc");
        set.add("abc");
        set.add("cde");
        set.add("cd");
        System.out.println(set);
        System.out.println(set.size());
        set.remove("cd");
        set.add("element");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains("cde"));
        
    }
}