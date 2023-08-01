package javaGoldPractis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new FileReader("File1"));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            if(br != null) br.close();
        }catch(FileNotFoundException e){
            System.out.println("fail not found");
        }catch(IOException e){
            System.out.println("IOE");
//        }finally{
//            try{
//                if(br != null) br.close();
//            }catch(IOException e){
//                System.out.println("IOE");
//            }
//        }
    }
}
}
