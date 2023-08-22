package lambda;

import java.util.function.Function;

interface greets{
	public String greet(int time , String text , Function<String , String> f);
}

class greetImpl implements greets{
	public String greet(int time , String text , Function<String , String> f) {
		String result = "";
		
		result += 0 <= time && time < 12 ? "Good Morning " : 12 <= time && time < 18 ? "Good Afternoon " : "Good Evening ";
		result += f.apply(text);
		
		return result;
	}
}

public class higherOrderFunctionPractis {
	
    public static void main(String[] args){

    	greets greetChangeTime = new greetImpl();
    	
    	
    	Function<String , String> loud = x -> x.toUpperCase();
    	Function<String , String> quiet = x -> x.toLowerCase();
    	Function<String , String> reverse = x -> {
    		String ans ="";
    		for(int i = 0; i < x.length(); i++) {
    			ans = x.charAt(i) + ans;
    		}
    		return ans;
    	};
    	Function<String , String> repeat = x -> x + " " + x;
    	
    	
    	System.out.println(greetChangeTime.greet(1 , "John" , loud));
    	System.out.println(greetChangeTime.greet(2 , "John" , quiet));
    	System.out.println(greetChangeTime.greet(13 , "John" , reverse));
    	System.out.println(greetChangeTime.greet(19 , "John" , repeat));
    	System.out.println(greetChangeTime.greet(13 , "Leslie Emmanuel Beadon" , loud));
    	System.out.println(greetChangeTime.greet(19, "Leslie Emmanuel Beadon", quiet));
    	System.out.println(greetChangeTime.greet(5, "Leslie Emmanuel Beadon", reverse));
    	System.out.println(greetChangeTime.greet(1, "Leslie Emmanuel Beadon", repeat));
    	
    }
}
