import java.util.*;

interface changeName{
    void printName();
}

interface addName{
    String conpareName(String name);
}

public class Main {
    public static void main(String[] args) throws Exception {
        // changeName name = new changeName(){
        //     @Override
        //     public void printName(){
        //         System.out.println("name changed");
        //     }
        //     @Override
        //     public String conpareName(String name){
        //         String before = "taro";
        //         return before + name;
        //     }
        // };
        
        changeName name = () -> {System.out.println("name changed");};
        addName name2 = (str) -> {return "taro " + str;};
        
        name.printName();
        System.out.println(name2.conpareName("Ichiro"));
    }
}
