package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamPractis {
    public static void main(String[] args) throws Exception {
        Integer[] a = Stream.of(1,2,3,4,5,5,5,5,5,5,6,7,8,9,10)
                            .filter(x -> x%2 !=0)
                            .distinct()
                            .toArray(Integer[]::new);
        
        System.out.println(Arrays.stream(a).count());
        
        Arrays.stream(a)
              .forEach(z-> System.out.print(z + " "));
        
        System.out.println();
        List<Integer> list = new ArrayList<>();
        list = List.of(1,2,3,4,5,5,5,5,5,5,6,7,8,9,10)
                  .stream()
                  .filter(x -> x %2 ==0)
                  .collect(Collectors.toList());
        System.out.println(list.stream().count());
        
        list.stream()
              .forEach(z-> System.out.print(z + " "));
        
        System.out.println();
        
        List<Integer> list2 = new ArrayList<>();
        list2 = Stream.of(1,2,3,4,5,5,5,5,5,5,6,7,8,9,10)
                     .filter(x -> x %2 !=0)
                     .distinct()
                     .collect(Collectors.toList());
        
        System.out.println(list2.stream().count());
        list2.stream()
              .forEach(z-> System.out.print(z + " "));


        Stream chars1 = Stream.of("b");
        Stream chars2 = Stream.of("a");
        // Stream chars = はあくまでも代入なのでforEachにprintlnが入っていると返り値がなくてエラーになってしまうので注意
        Stream.concat(chars1 , chars2)
              .filter(x -> x != "a")
              .forEach(x -> System.out.println(x));

        List<String> listStr = new ArrayList<>();
        for(int i = (int)'a'; i<=(int)'z';i++) listStr.add(""+(char)i);
        
        System.out.println(listStr);

        listStr.stream()
               .filter(x -> (int)x.charAt(0) %2 != 0)
               .filter(x -> (int)x.charAt(0) < 100)
               .forEach(System.out::print);

        
    }
}
