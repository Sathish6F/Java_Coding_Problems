import java.util.*;
class DemoFile{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,5,2,6,3,2,7,8,9,4));
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer i1,Integer i2){
                if((Math.abs(i1-i2))%2 == 0){
                    if(i1%2 == 0)
                        return (i1>i2)?1:-1;
                    else
                        return (i1<i2)?1:-1;    
                }
                return (i1%2 == 0 && i2%2 !=0)?-1:1;
            }
        }; 
        list.sort(comp);
        System.out.println(list);
    }
}
