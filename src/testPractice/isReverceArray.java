package testPractice;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class isReverceArray {
    public static void main(String[] args) throws Exception {
        String[] list = {"a","b","c","D","e","f"};
        String[] list2 = deepCopy(list);
        reverseArr(list);
        BiPredicate<String[],String[]> reverseArrCheack = (nomalList , revList) ->{
            if(nomalList.length != revList.length) return false;
            for(int i = 0; i < nomalList.length-1; i++){
                int counterNum = (nomalList.length-1)-i;
                if(nomalList[i] != revList[counterNum]) return false;
            }
            return true;
        };

        cheackAssertion(list,list2,reverseArrCheack);
    }
    
    public static void reverseArr(String[] list){
        for(int i = 0; i < (list.length)/2 ; i++){
            String temp = list[i];
            int counterNum = list.length-1-i;
            list[i] = list[counterNum];
            list[counterNum] = temp;
        }
    }
    public static boolean cheackAssertion(String[] a, String[] b,BiPredicate<String[],String[]> func)throws Exception{
        System.out.println("chackAssertion "+Arrays.toString(a) +" : "+Arrays.toString(b));
        Assertion.run(func.test(a,b));
        return func.test(a,b);
    }
    
    public static String[] deepCopy(String[] list){
        String[] copy = new String[list.length];
        for(int i = 0; i < list.length; i++){
            copy[i] = list[i];
        } 
        return copy;
    }
}

class Assertion{
    public static void run(boolean b)throws Exception{
        if(!b) throw new Exception("アサートエラーです");   
        else System.out.println(b);
    }
}
