package lambda;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

//自然数によって構成される配列と、配列のそれぞれの要素に特定の処理を実行するコールバック関数 f を受け取り、
//f の基準に基づいて新しい配列の要素を順に出力する customArray(int(int), int[]) という関数を作成しテストケースを出力してください。
//
//int cube(int n)
//整数 n を受け取って、3 乗にして返す関数。
//
//int splitAndAdd(int n)
//整数 n を受け取って、全ての桁数を合計して返す関数。

//customArray(cube, [3, 11, 24, 31])
//--> 27
//--> 1331
//--> 13824
//--> 29791
//
//customArray(splitAndAdd, [3, 11, 24, 31])
//--> 3
//--> 2
//--> 6
//--> 4
public class custumListPractis {
	public static void main(String[] args) {
		Function<Integer , Integer> cube = x -> x*x*x;
		Function<Integer , Integer> splitAndAdd = x -> {
			int totalNum =0;
			
			while(x > 0) {
				totalNum += x%10;
				x = x / 10;
			}
			return totalNum;
		};
		
		BiFunction<Function<Integer , Integer> , int[] , ArrayList<Integer>> customArray = (f , list) ->{
			ArrayList<Integer> newList = new ArrayList<>();
			for(int i = 0; i < list.length;i++) {
				newList.add(f.apply(list[i]));
			}
			
			for(Integer a : newList) System.out.println(a);
			return newList;
		};

		customArray.apply(cube , new int[] {3, 11, 24, 31});
		customArray.apply(splitAndAdd , new int[] {3, 11, 24, 31});
	}
}
