package lambda;

import java.util.function.Function;

class higherOrderFunction{
    public static void main(String[] args){
                Function<String,Function<Integer, String>> weightFormulaByPlanet = y -> x ->{
            switch(y){
                case "Earth":
                    return "The weight on " + y + " is " + (int)Math.floor(x*9.8);
                case "Mars":
                    return  "The weight on" + y + "is " + (int)Math.floor(x*3.7);
                case "Jupiter":
                    return  "The weight on" + y + "is " + (int)Math.floor(x*24.8);
                default:
                    return  "The weight on" + y + "is notfound";
            }
        };
        Function<Integer, String> getWeightOnEarth = weightFormulaByPlanet.apply("Earth");
        System.out.println(getWeightOnEarth.apply(50));
        Function<Integer, String> getWeightOnMars = weightFormulaByPlanet.apply("Mars");
        System.out.println(getWeightOnMars.apply(70));
        Function<Integer, String> getWeightOnJupiter = weightFormulaByPlanet.apply("Jupiter");
        System.out.println(getWeightOnJupiter.apply(90));
    }
}
