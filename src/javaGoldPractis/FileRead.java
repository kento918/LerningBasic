import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            br = new BufferedReader(new FileReader("File1"));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            System.out.println("fail not found");
        }catch(IOExeption e){
            System.out.println("IOE");
        }finally{
            try{
                if(br != null) br.close();
            }catch(IOExeption e){
                System.out.println("IOE");
            }
        }
    }
}
