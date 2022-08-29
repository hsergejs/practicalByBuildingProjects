package myUtilities;

import java.util.List;

public class MyUtilities {
    public static <T> void printList(List<T> list){
        for(T unit : list){
            System.out.println(unit.toString());
        }
    }
}
