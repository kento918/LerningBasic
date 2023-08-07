import java.util.*;
import java.util.stream.*;

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
    }
}
